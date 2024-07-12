package com.message.dtos;

public record ResponseMessage() {

	public static final String SUCCESSFULLY = "Successfully";
	public static final String WRONG_PASSWORD = "Wrong password";
	public static final String USER_NOT_FOUND = "User not found";
	public static final String SENDER_AND_RECIPIENT_MATCH = "Sender and recipient cannot be the same person";
	public static final String AUTHENTICATED_USER_NOT_FOUND = "Authenticated user not found";
}
