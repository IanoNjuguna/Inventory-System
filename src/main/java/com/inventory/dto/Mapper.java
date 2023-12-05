package com.inventory.dto;

public interface Mapper<A, B> {
	
	B mapEntityToDto(A a);
	
	A mapDtoToEntity(B b);

}
