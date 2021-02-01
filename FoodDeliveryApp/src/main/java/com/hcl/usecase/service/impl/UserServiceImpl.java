package com.hcl.usecase.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.usecase.api.BankingService;
import com.hcl.usecase.api.dto.AccountIdOnlyDto;
import com.hcl.usecase.api.dto.AccountResponseDto;
import com.hcl.usecase.api.dto.TransferRequestDto;
import com.hcl.usecase.api.error.InsufficientBalanceException;
import com.hcl.usecase.model.Food;
import com.hcl.usecase.model.FoodOrder;
import com.hcl.usecase.model.FoodOrder.OrderStatus;
import com.hcl.usecase.model.User;
import com.hcl.usecase.repository.FoodRepository;
import com.hcl.usecase.repository.OrderRepository;
import com.hcl.usecase.repository.UserRepository;
import com.hcl.usecase.repository.VendorRepository;
import com.hcl.usecase.service.UserService;

import feign.FeignException;

@Service
public class UserServiceImpl implements UserService {

	@Value("${vendor.account}")
	private Long VENDOR_ACCOUNT;;

	@Value("${order.comment.successful}")
	private String ORDER_COMMENT_SUCCESSFUL;

	@Value("${order.comment.failure}")
	private String ORDER_COMMENT_FAILURE;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private BankingService bankingService;

	@Override
	@Transactional
	public FoodOrder placeOrder(FoodOrder order) throws InsufficientBalanceException {
		User user = userRepository.findById(order.getUser().getId()).get();
		AccountIdOnlyDto fromAcc = new AccountIdOnlyDto(order.getAccountNo());
		Double totalBill = order.getOrderUnits().stream().map(item -> {
			Food food = foodRepository.findById(item.getFood().getId()).get();
			return food.getPrice();
		}).reduce(0d,(a,b)->a+b);
		AccountResponseDto accountResponseDto = bankingService.getBalance(order.getAccountNo()).getBody();
		try {
			if(accountResponseDto.getBalanceDetail().getBalance()<totalBill)
				throw new InsufficientBalanceException();
			
			
			order.getOrderUnits().stream().forEach(item -> {
				Food food = foodRepository.findById(item.getFood().getId()).get();
				Double amount = food.getPrice() * item.getQuantity();
				AccountIdOnlyDto toAcc = new AccountIdOnlyDto(vendorRepository
						.findById(foodRepository.findById(item.getFood().getId()).get().getVendor().getId()).get()
						.getAccountNumber());
				TransferRequestDto transferRequestDto = new TransferRequestDto(fromAcc, toAcc, amount);
				bankingService.transfer(transferRequestDto);

			});

			order.setOrderStatus(OrderStatus.ACCEPTED);
			order.setComment(ORDER_COMMENT_SUCCESSFUL);
		} catch (Exception e) {
			String comment = ORDER_COMMENT_FAILURE;
			if(e instanceof  InsufficientBalanceException)
				comment = comment + " : due to insufficient balance";
			else if (e instanceof FeignException)
				comment = comment + " : failed to contact bank";
			else
				comment = comment + e.getMessage();
			order.setComment(comment);
			order.setOrderStatus(OrderStatus.REJECTED);
		} finally {
			order = orderRepository.save(order);
			user.getOrders().add(order);
			userRepository.save(user);
		}
		return order;

	}

	@Override
	public List<Food> searchFood(String name) {
		return foodRepository.findByNameContainsIgnoringCase(name);
	}

	@Override
	public List<FoodOrder> getOrderHistory(Long userId) {
		User user = userRepository.findById(userId).get();
		return user.getOrders();
	}

}
