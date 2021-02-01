package com.hcl.usecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.hcl.usecase.config.RibbonConfig;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@RibbonClient(name="food-client",configuration = RibbonConfig.class)
public class FoodDeliveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryAppApplication.class, args);
	}

}
