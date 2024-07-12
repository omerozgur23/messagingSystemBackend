CREATE TABLE users (
  id BINARY(16) NOT NULL,
  username VARCHAR(20) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(200) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX username_unq (username ASC) VISIBLE,
  UNIQUE INDEX email_unq (email ASC) VISIBLE
);