package com.grupo13.model;

public class TestResult {



	private String message;
	private String name;
	private boolean isOK;

	public TestResult(String name, String msg, boolean result) {
		message = msg;
		this.name = name;
		isOK = result;
	}
	
	public TestResult(String name) {
		this.name = name;
		isOK = true;
	}


	public TestResult() {
		name = "";
		isOK = false;
	}
	
	public boolean isValid() {
		return !name.equals("");
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return String.format("%1$-" + 50 + "s", name)+"|"+
				String.format("%1$-" + 10 + "s", isOK()?"Pass":"Failed")+"|"+
				String.format("%1$-" + 30 + "s", message);
	}
}
