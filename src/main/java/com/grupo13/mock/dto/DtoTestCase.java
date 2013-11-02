package com.grupo13.mock.dto;

import com.grupo13.mock.idto.IDtoTest;


public class DtoTestCase implements IDtoTest{
	String message;

	public DtoTestCase(String message){
		this.message = message;
	}
	
	@Override
	public String getMessage(String nameProject) {
		return "\n\t" + message;
	}
}