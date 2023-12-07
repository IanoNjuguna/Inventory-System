package com.inventory.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationRequestObject { 
	
	private String firstName;
	private String lastName;
	private String email;
	private String contact;
	private String password;	
	
}
