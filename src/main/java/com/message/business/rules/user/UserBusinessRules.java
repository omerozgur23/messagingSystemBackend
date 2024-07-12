package com.message.business.rules.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.message.core.utilities.AuthenticatedUser;
import com.message.core.utilities.exception.BusinessException;
import com.message.dataAccess.UserRepository;
import com.message.dtos.ResponseMessage;
import com.message.entities.concretes.User;

@Service
public class UserBusinessRules {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User checkUserExitstsById(UUID userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new BusinessException(ResponseMessage.USER_NOT_FOUND));
		return user;
	}

	public Optional<User> checkUserExists(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (!user.isPresent()) {
			throw new BusinessException(ResponseMessage.USER_NOT_FOUND);
		}
		return user;
	}

	public boolean checkPassword(User user, String password) {
		if (passwordEncoder.matches(password, user.getPassword())) {
			return true;
		} else {
			throw new BusinessException(ResponseMessage.WRONG_PASSWORD);
		}
	}

	public User getCurrentUser() {
		String authenticatedEmail = AuthenticatedUser.getCurrentUser();
		User currentUser = userRepository.findByEmail(authenticatedEmail);
		if (currentUser.getEmail().equals(authenticatedEmail)) {
			return currentUser;
		} else {
			throw new BusinessException(ResponseMessage.AUTHENTICATED_USER_NOT_FOUND);
		}
	}

}
