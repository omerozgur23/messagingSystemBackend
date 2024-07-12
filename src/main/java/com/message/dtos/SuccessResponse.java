package com.message.dtos;

import lombok.Data;

@Data
public class SuccessResponse {

	private String message = ResponseMessage.SUCCESSFULLY;
}
