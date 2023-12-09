package com.inventory.event;

import org.springframework.context.ApplicationEvent;

import com.inventory.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 5694836820364265577L;
	
	private User user;
	private String applicationUrl;
	
	public RegistrationCompleteEvent(User user, String applicationUrl) {
		super(user);
		this.user = user;
		this.applicationUrl = applicationUrl;
	}
	
}
