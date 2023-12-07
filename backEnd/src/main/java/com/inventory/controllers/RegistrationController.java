package com.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inventory.security.RegistrationRequestObject;

@Controller
public class RegistrationController {
	
	@GetMapping("/register")
	public String register(Model model) {
		RegistrationRequestObject newCustomer =
				new RegistrationRequestObject();
		
		model.addAttribute("newCustomer", newCustomer);
		return "register";
	}

}
