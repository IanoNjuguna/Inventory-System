package com.inventory.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.inventory.customer.Customer;
import com.inventory.customer.dto.CustomerDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerMapper implements Mapper<Customer, CustomerDto> {

	private final ModelMapper modelMapper;
	
	@Override
	public CustomerDto mapEntityToDto(Customer customer) {
		return modelMapper.map(customer, CustomerDto.class);		 
	}

	@Override
	public Customer mapDtoToEntity(CustomerDto customerDto) {
		return modelMapper.map(customerDto, Customer.class);
	}

}
