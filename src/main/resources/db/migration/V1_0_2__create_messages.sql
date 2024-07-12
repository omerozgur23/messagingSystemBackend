CREATE TABLE messages (
  id BINARY(16) NOT NULL,
  sending_user_id BINARY(16) NOT NULL,
  recipient_user_id BINARY(16) NOT NULL,
  message_content VARCHAR(1000) NOT NULL,
  sending_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  is_readed BOOLEAN DEFAULT FALSE NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT sending_message_user_fk
  	FOREIGN KEY (sending_user_id)
  	REFERENCES users (id),
  CONSTRAINT recipient_message_user_fk
  	FOREIGN KEY (recipient_user_id)
  	REFERENCES users (id)
);