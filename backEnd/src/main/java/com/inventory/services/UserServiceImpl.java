package com.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.dto.Mapper;
import com.inventory.exception.UserAlreadyExistsException;
import com.inventory.exception.UserNotFoundException;
import com.inventory.models.User;
import com.inventory.objects.RegistrationRequest;
import com.inventory.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;
	
	private final Mapper<User, RegistrationRequest> mapper;
	
	private final PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User registerUser(RegistrationRequest registrationRequest) {
		Optional<User> user = 
				userRepository.findByEmail(registrationRequest.getEmail());
		
		if (user.isPresent()) {
			throw new UserAlreadyExistsException(
					"Email already exists"
					);		
		}
		
		User newUser = mapper.mapDtoToEntity(registrationRequest);
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		newUser.setRole("USER");
		
		return userRepository.save(newUser);
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);				
	}

	@Override
	public User updateUser(Long id, RegistrationRequest registrationRequest) throws Exception {
		User user = mapper.mapDtoToEntity(registrationRequest);
		return userRepository.findById(id)				
				.map( (existingUser) -> {
					Optional.ofNullable(existingUser.getFirstName())
							.ifPresent(user::setFirstName);
					Optional.ofNullable(existingUser.getLastName())
							.ifPresent(user::setLastName);
					Optional.ofNullable(existingUser.getEmail())
							.ifPresent(user::setEmail);
					Optional.ofNullable(existingUser.getContact())
							.ifPresent(user::setContact);
					Optional.ofNullable(existingUser.getPassword())
							.ifPresent(user::setPassword);
					Optional.ofNullable(existingUser.getRole())
							.ifPresent(user::setRole);
					
					return userRepository.save(existingUser);					
				})
				.orElseThrow(() -> 
						new UserNotFoundException("No such user exists"));	
	}

	@Override
	public void deleteUser(Long id) {		
		userRepository.deleteById(id);
	}

}
