package com.message.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.business.abstracts.UserService;
import com.message.dtos.PageResponse;
import com.message.dtos.user.GetAllUsersExceptCurrent;

@RestController
@RequestMapping("/api/v1/user")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/getall")
	public PageResponse<GetAllUsersExceptCurrent> getAll() {
		return userService.getAllUsersExceptCurrent();
	}
}
