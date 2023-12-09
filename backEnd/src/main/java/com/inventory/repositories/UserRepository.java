package com.inventory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
