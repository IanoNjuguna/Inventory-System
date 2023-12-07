package com.inventory.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.inventory.controllers.dto.CustomerDto;
import com.inventory.models.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerMapper implements Mapper<User, CustomerDto> {

	private final ModelMapper modelMapper;
	
	@Override
	public CustomerDto mapEntityToDto(User customer) {
		return modelMapper.map(customer, CustomerDto.class);		 
	}

	@Override
	public User mapDtoToEntity(CustomerDto customerDto) {
		return modelMapper.map(customerDto, User.class);
	}

}
