package com.grupo13.mock.dto;

import com.grupo13.mock.idto.IDtoTest;

public class DtoTestCase implements IDtoTest {
	String message;
	boolean isOk;
	boolean isFail;

	public DtoTestCase(boolean isFail, boolean isOk, String message) {
		this.message = message;
		this.isOk = isOk;
		this.isFail = isFail;
	}

	@Override
	public String getMessage(String nameProject) {
		return "\n\t" + message;
	}

	@Override
	public int getNumberOfTestCase() {
		return 1;
	}

	@Override
	public int getNumberOfErrors() {
		return ((!isFail) && (isOk)) ? 1 : 0;
	}

	@Override
	public int getNumberOfFailures() {
		return (isFail) ? 1 : 0;
	}
}