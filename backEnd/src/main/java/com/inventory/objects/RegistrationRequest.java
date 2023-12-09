package com.inventory.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationRequest { 
	
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String password;	
	private String role;
}
