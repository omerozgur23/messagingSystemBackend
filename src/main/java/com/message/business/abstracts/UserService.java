package com.message.business.abstracts;

import java.util.UUID;

import com.message.dtos.PageResponse;
import com.message.dtos.user.GetAllUsersExceptCurrent;
import com.message.entities.concretes.User;

public interface UserService {

	PageResponse<GetAllUsersExceptCurrent> getAllUsersExceptCurrent();

	User getAuthenticatedUser();

	User getUser(UUID userId);

}
