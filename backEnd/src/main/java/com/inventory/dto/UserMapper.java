package com.inventory.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.inventory.models.User;
import com.inventory.objects.LoginRequestObject;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, LoginRequestObject> {
	
	private final ModelMapper modelMapper;
	
	@Override
	public LoginRequestObject mapEntityToDto(User customer) {
		return modelMapper.map(customer, LoginRequestObject.class);		 
	}

	@Override
	public User mapDtoToEntity(LoginRequestObject loginRequestObject) {
		return modelMapper.map(loginRequestObject, User.class);
	}

}
