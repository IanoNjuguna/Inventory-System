package com.inventory.exception;


public class UserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4854765045624623002L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
	
}
