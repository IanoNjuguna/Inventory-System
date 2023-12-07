package com.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.models.User;

public interface CustomerRepository extends JpaRepository<User, Long> {

}
