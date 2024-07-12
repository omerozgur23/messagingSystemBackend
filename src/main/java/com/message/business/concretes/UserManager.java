package com.message.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.business.abstracts.UserService;
import com.message.business.rules.user.UserBusinessRules;
import com.message.core.utilities.config.mapper.ModelMapperService;
import com.message.dataAccess.UserRepository;
import com.message.dtos.PageResponse;
import com.message.dtos.user.GetAllUsersExceptCurrent;
import com.message.entities.concretes.User;

@Service
public class UserManager implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserBusinessRules userBusinessRules;

	@Autowired
	private ModelMapperService modelMapper;

	@Override
	public PageResponse<GetAllUsersExceptCurrent> getAllUsersExceptCurrent() {
		User authenticatedUser = getAuthenticatedUser();
		List<User> users = userRepository.findAll();

		List<GetAllUsersExceptCurrent> responseUsers = users.stream()
				.filter(user -> !user.getId().equals(authenticatedUser.getId()))
				.map(user -> modelMapper.forResponse().map(user, GetAllUsersExceptCurrent.class)).toList();

		int userCount = responseUsers.size();
		return new PageResponse<GetAllUsersExceptCurrent>(userCount, responseUsers);
	}

	@Override
	public User getAuthenticatedUser() {
		User user = userBusinessRules.getCurrentUser();
		return user;
	}

	@Override
	public User getUser(UUID userId) {
		return userBusinessRules.checkUserExitstsById(userId);
	}

}
