package com.message.entities.concretes;

import com.message.entities.abstarcts.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "sending_user_id")
	private User senderUser;

	@ManyToOne
	@JoinColumn(name = "recipient_user_id")
	private User recipientUser;

	@Column(name = "message_content")
	private String messageContent;

	@Column(name = "sending_date")
	private String sendingDate;

	@Column(name = "is_readed")
	private boolean isReaded;
}
