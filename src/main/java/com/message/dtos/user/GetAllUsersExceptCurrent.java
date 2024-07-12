package com.message.dtos.user;

import java.util.UUID;

import lombok.Data;

@Data
public class GetAllUsersExceptCurrent {

	private UUID id;

	private String username;

	private String email;
}
