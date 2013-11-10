package com.grupo13.dto;

import com.grupo13.idto.IDtoTest;

public class DtoTestCase implements IDtoTest {
	private String message;
	private boolean isOk;
	private boolean isError;
	private String path;
	
	public DtoTestCase(boolean isError, boolean isOk, String message) {
		this.message = message;
		this.isOk = isOk;
		this.isError = isError;
	}

	@Override
	public String getMessage() {
		return "\n\t" + message;
	}

	@Override
	public int getNumberOfTestCase() {
		return 1;
	}

	@Override
	public int getNumberOfErrors() {
		return (isError) ? 1 : 0;
	}

	@Override
	public int getNumberOfFailures() {
		return ((!isError) && (!isOk)) ? 1 : 0;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}
}