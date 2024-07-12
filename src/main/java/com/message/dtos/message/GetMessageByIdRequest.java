package com.message.dtos.message;

import java.util.UUID;

import lombok.Data;

@Data
public class GetMessageByIdRequest {

	private UUID messageId;
}
