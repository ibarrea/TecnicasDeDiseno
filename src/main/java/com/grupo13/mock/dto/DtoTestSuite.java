package com.grupo13.mock.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo13.mock.idto.IDtoTest;



public class DtoTestSuite implements IDtoTest{
	
	String message;
	List<IDtoTest> lDtoTestCase = new ArrayList<IDtoTest>();
	
	public DtoTestSuite(String message){
		this.message = message;
	}
	
	public void add(IDtoTest iDtoTest){
		if(!lDtoTestCase.contains(iDtoTest)){
			lDtoTestCase.add(iDtoTest);
		}
	}
	
	@Override
	public String getMessage(String nameProject) {
		String str = message;
		String path = message;
		if(!nameProject.equals("")){
			str = "\n" + nameProject + "." + message;
			path = nameProject + "." + message;
		}
		for(IDtoTest idtoTest: lDtoTestCase){
			str += idtoTest.getMessage(path);
		}
		return str;
	}

}

