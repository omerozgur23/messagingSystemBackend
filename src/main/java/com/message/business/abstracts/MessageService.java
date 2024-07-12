package com.message.business.abstracts;

import com.message.dtos.PageResponse;
import com.message.dtos.SuccessResponse;
import com.message.dtos.message.GetMessageByIdRequest;
import com.message.dtos.message.GetMessageResponse;
import com.message.dtos.message.SendMessageRequest;

public interface MessageService {

	GetMessageResponse getMessageById(GetMessageByIdRequest request);

	PageResponse<GetMessageResponse> getMessagesByRecipientUserId();

	PageResponse<GetMessageResponse> getUnreadeMessages();

	SuccessResponse sendMessage(SendMessageRequest request);
}
