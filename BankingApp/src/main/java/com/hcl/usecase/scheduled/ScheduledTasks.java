package com.hcl.usecase.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hcl.usecase.service.AdminService;

@Component
public class ScheduledTasks {

	@Autowired
	private AdminService adminService;
	
	@Scheduled(cron = "0 */2 * * * *")
	public void activateAccounts() {
		adminService.activateAccounts();
	}
}
