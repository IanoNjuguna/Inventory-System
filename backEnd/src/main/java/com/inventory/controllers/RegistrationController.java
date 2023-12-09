package com.inventory.controllers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.event.RegistrationCompleteEvent;
import com.inventory.models.User;
import com.inventory.objects.RegistrationRequest;
import com.inventory.services.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {
	
	private final IUserService userService;
	private final ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<String> register(RegistrationRequest registrationRequest,
										final HttpServletRequest request) {
		
		User registerUser = userService.registerUser(registrationRequest);
		// publish registration event
		publisher.publishEvent(
					new RegistrationCompleteEvent(registerUser, null));
		// send email
		
		return ResponseEntity.ok("Registration successful");
	}

}
