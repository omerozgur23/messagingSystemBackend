package com.message.business.abstracts;

import com.message.dtos.login.LoginRequest;
import com.message.dtos.login.LoginResponse;

public interface LoginService {

	LoginResponse login(LoginRequest request);
}
