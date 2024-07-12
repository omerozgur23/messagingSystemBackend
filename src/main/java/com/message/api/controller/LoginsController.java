package com.message.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.business.abstracts.LoginService;
import com.message.dtos.login.LoginRequest;
import com.message.dtos.login.LoginResponse;

@RestController
@RequestMapping("/api/v1")
public class LoginsController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return loginService.login(request);
	}
}
