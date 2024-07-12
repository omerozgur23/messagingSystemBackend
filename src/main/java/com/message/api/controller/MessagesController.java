package com.message.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.business.abstracts.MessageService;
import com.message.dtos.PageResponse;
import com.message.dtos.SuccessResponse;
import com.message.dtos.message.GetMessageByIdRequest;
import com.message.dtos.message.GetMessageResponse;
import com.message.dtos.message.SendMessageRequest;

@RestController
@RequestMapping("/api/v1/message")
public class MessagesController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/get")
	public PageResponse<GetMessageResponse> getMessagesByRecipientUserId() {
		return messageService.getMessagesByRecipientUserId();
	}

	@PostMapping("/getbyid")
	public GetMessageResponse getMessageById(@RequestBody GetMessageByIdRequest request) {
		return messageService.getMessageById(request);
	}

	@PostMapping("/send")
	public SuccessResponse sendMessage(@RequestBody SendMessageRequest request) {
		return messageService.sendMessage(request);
	}

	@GetMapping("/unread")
	public PageResponse<GetMessageResponse> getUnreadeMessages() {
		return messageService.getUnreadeMessages();
	}
}
