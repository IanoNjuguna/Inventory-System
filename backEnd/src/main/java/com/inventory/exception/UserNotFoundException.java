package com.inventory.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1397516938710442509L;

	public UserNotFoundException(String message) {
		super(message);		
	}
	
	

}
