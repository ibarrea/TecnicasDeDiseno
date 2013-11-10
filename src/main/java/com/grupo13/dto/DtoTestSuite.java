package com.grupo13.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo13.idto.IDtoTest;

public class DtoTestSuite implements IDtoTest {
	String message;
	List<IDtoTest> lDtoTestCase = new ArrayList<IDtoTest>();
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<IDtoTest> getlDtoTestCase() {
		return lDtoTestCase;
	}

	public void setlDtoTestCase(List<IDtoTest> lDtoTestCase) {
		this.lDtoTestCase = lDtoTestCase;
	}

	public DtoTestSuite() {

	}

	
	
	
	
	
	public DtoTestSuite(String message) {
		this.message = message;
	}

	public void add(IDtoTest iDtoTest) {
		if (!lDtoTestCase.contains(iDtoTest)) {
			lDtoTestCase.add(iDtoTest);
		}
	}

	@Override
	public String getMessage(String nameProject) {
		String str = message;
		String path = message;
		if (!nameProject.equals("")) {
			str = "\n" + nameProject + "." + message;
			path = nameProject + "." + message;
		}
		for (IDtoTest idtoTest : lDtoTestCase) {
			str += idtoTest.getMessage(path);
		}
		return str;
	}

	@Override
	public int getNumberOfTestCase() {
		int count = 0;
		for (IDtoTest idtoTest : lDtoTestCase) {
			count += idtoTest.getNumberOfTestCase();
		}
		return count;
	}

	@Override
	public int getNumberOfErrors() {
		int count = 0;
		for (IDtoTest idtoTest : lDtoTestCase) {
			count += idtoTest.getNumberOfErrors();
		}
		return count;
	}

	@Override
	public int getNumberOfFailures() {
		int count = 0;
		for (IDtoTest idtoTest : lDtoTestCase) {
			count += idtoTest.getNumberOfFailures();
		}
		return count;
	}

}
