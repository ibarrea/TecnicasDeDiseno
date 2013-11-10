package com.grupo13.dto;

import java.util.ArrayList;
import java.util.List;

import com.grupo13.idto.IDtoTest;

public class DtoTestSuite implements IDtoTest {
	private String message;
	private String path;
	List<IDtoTest> lDtoTestCase = new ArrayList<IDtoTest>();

	
	public DtoTestSuite(String message) {
		this.message = message;
	}

	public void add(IDtoTest iDtoTest) {
		if (!lDtoTestCase.contains(iDtoTest)) {
			lDtoTestCase.add(iDtoTest);
		}
	}

	@Override
	public String getMessage() {
		String str = message;
		String pathini = message;
		if (!path.equals("")) {
			str = "\n" + path + "." + message;
			pathini = path + "." + message;
		}
		for (IDtoTest idtoTest : lDtoTestCase) {
			idtoTest.setPath(pathini);
			str += idtoTest.getMessage();
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

	@Override
	public void setPath(String path) {
		this.path = path;
	}

}
