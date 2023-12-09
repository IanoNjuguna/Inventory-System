package com.inventory.controllers;

import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.models.User;
import com.inventory.objects.RegistrationRequest;
import com.inventory.services.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final IUserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {		
		return ResponseEntity.ok(userService.getAllUsers());
	}	

}
