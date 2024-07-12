package com.message.dataAccess;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.message.entities.concretes.Message;

public interface MessageRepository extends JpaRepository<Message, UUID> {

	List<Message> findByRecipientUserIdOrderBySendingDateDesc(UUID userId);
}
