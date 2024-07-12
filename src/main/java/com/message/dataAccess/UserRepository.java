package com.message.dataAccess;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.message.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findByUsername(String username);

	User findByEmail(String email);
}
