package com.message.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.business.abstracts.MessageService;
import com.message.business.abstracts.UserService;
import com.message.business.rules.message.MessageBusinessRules;
import com.message.core.utilities.config.mapper.ModelMapperService;
import com.message.dataAccess.MessageRepository;
import com.message.dtos.PageResponse;
import com.message.dtos.SuccessResponse;
import com.message.dtos.message.GetMessageByIdRequest;
import com.message.dtos.message.GetMessageResponse;
import com.message.dtos.message.SendMessageRequest;
import com.message.entities.concretes.Message;
import com.message.entities.concretes.User;

@Service
public class MessageManager implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private MessageBusinessRules messageBusinessRules;

	@Autowired
	private ModelMapperService modelMapper;

	@Autowired
	private UserService userService;

	@Override
	public PageResponse<GetMessageResponse> getMessagesByRecipientUserId() {
		User authecticatedUser = userService.getAuthenticatedUser();

		List<Message> messages = messageRepository
				.findByRecipientUserIdOrderBySendingDateDesc(authecticatedUser.getId());

		List<GetMessageResponse> responseMessages = messages.stream()
				.map(message -> modelMapper.forResponse().map(message, GetMessageResponse.class)).toList();

		int messageCount = responseMessages.size();
		return new PageResponse<>(messageCount, responseMessages);
	}

	@Override
	public GetMessageResponse getMessageById(GetMessageByIdRequest request) {
		Message message = messageRepository.findById(request.getMessageId()).orElseThrow();
		message.setReaded(true);
		messageRepository.save(message);
		GetMessageResponse responseMessage = modelMapper.forResponse().map(message, GetMessageResponse.class);
		return responseMessage;
	}

	@Override
	public SuccessResponse sendMessage(SendMessageRequest request) {
		User senderUser = userService.getAuthenticatedUser();
		User recipientUser = userService.getUser(request.getRecipientUser());

		messageBusinessRules.checkSenderAndRecipient(senderUser.getId(), recipientUser.getId());
		String localDate = messageBusinessRules.formattedLocalDate();

		Message message = modelMapper.forRequest().map(request, Message.class);
		message.setSenderUser(senderUser);
		message.setRecipientUser(recipientUser);
		message.setSendingDate(localDate);
		message.setReaded(false);

		messageRepository.save(message);
		return new SuccessResponse();
	}

	@Override
	public PageResponse<GetMessageResponse> getUnreadeMessages() {
		User authecticatedUser = userService.getAuthenticatedUser();

		List<Message> messages = messageRepository
				.findByRecipientUserIdOrderBySendingDateDesc(authecticatedUser.getId());

		List<GetMessageResponse> responseMessages = messages.stream().filter(message -> !message.isReaded())
				.map(message -> modelMapper.forResponse().map(message, GetMessageResponse.class)).toList();

		int messageCount = responseMessages.size();
		return new PageResponse<>(messageCount, responseMessages);
	}
}
