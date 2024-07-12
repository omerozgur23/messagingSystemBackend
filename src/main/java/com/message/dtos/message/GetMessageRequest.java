package com.message.dtos.message;

import java.util.UUID;

import lombok.Data;

@Data
public class GetMessageRequest {

	private UUID recipientUserId;
}
