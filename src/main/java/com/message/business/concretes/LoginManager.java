package com.message.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.business.abstracts.LoginService;
import com.message.business.rules.user.UserBusinessRules;
import com.message.core.utilities.config.jwt.JwtConfig;
import com.message.dtos.login.LoginRequest;
import com.message.dtos.login.LoginResponse;
import com.message.entities.concretes.User;

@Service
public class LoginManager implements LoginService {

	@Autowired
	private UserBusinessRules userBusinessRules;

	@Autowired
	private JwtConfig jwtConfig;

	@Override
	public LoginResponse login(LoginRequest request) {
		Optional<User> user = userBusinessRules.checkUserExists(request.getUsername());
		userBusinessRules.checkPassword(user.get(), request.getPassword());
		String token = jwtConfig.createToken(user.get());
		return new LoginResponse(token);
	}

}
