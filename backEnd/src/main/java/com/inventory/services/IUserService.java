package com.inventory.services;

import java.util.List;
import java.util.Optional;

import com.inventory.models.User;
import com.inventory.objects.RegistrationRequest;

public interface IUserService {

	List<User> getAllUsers();

	User registerUser(RegistrationRequest registrationRequest);

	Optional<User> findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	User updateUser(Long id, RegistrationRequest registrationRequest) throws Exception;

	void deleteUser(Long id);

}
