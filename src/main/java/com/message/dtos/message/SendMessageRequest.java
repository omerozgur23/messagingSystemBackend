package com.message.dtos.message;

import java.util.UUID;

import lombok.Data;

@Data
public class SendMessageRequest {

	private UUID recipientUser;

	private String messageContent;
}
