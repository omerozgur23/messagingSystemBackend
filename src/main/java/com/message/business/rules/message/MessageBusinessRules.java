package com.message.business.rules.message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.message.core.utilities.exception.BusinessException;
import com.message.dtos.ResponseMessage;

@Service
public class MessageBusinessRules {

	public String formattedLocalDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		return formattedDateTime;
	}

	public void checkSenderAndRecipient(UUID senderId, UUID recipientId) {
		if (senderId == recipientId) {
			throw new BusinessException(ResponseMessage.SENDER_AND_RECIPIENT_MATCH);
		}
	}
}
