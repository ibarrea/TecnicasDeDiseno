package com.grupo13.model;

public class TestResult {

	private String messenger;
	private String name;
	private boolean isOK;

	public TestResult(String name, String messenger, boolean result) {
		this.messenger = messenger;
		this.name = name;
		this.isOK = result;
	}

	
	
	public boolean isOK() {
		return isOK;
	}



	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}



	public String getMessenger() {
		return messenger;
	}

	public String getName() {
		return name;
	}
}
