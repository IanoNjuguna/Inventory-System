package com.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventory.security.LoginRequestObject;

@Controller
public class LoginController {			
	
	@PostMapping("/login")
	public String login(Model model) {
		LoginRequestObject loginRequest =
				new LoginRequestObject();
		
		model.addAttribute("login", loginRequest);
		return "login";
	}

}
