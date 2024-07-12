package com.message.dtos.message;

import java.util.UUID;

import lombok.Data;

@Data
public class GetMessageResponse {

	private UUID id;

	private String senderUsername;

	private String messageContent;

	private String sendingDate;

	private boolean isReaded;
}
