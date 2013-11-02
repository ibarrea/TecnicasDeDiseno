package com.grupo13.model;

public class TestCase  extends TestComponent {

	private String message;

	public TestCase(String testName, String msg, boolean result) {
		message = msg;
		name = testName;
		isOK = result;
	}
	
	public TestCase(String name) {
		super();
		this.name = name;
	}

	public TestCase() {
		super();
		name = "";
		isOK = false;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public String toString() {
		return String.format("%1$-" + 55 + "s", name)+"|"+
				String.format("%1$-" + 10 + "s", isOK()?"Pass":"Failed")+"|"+
				String.format("%1$-" + 30 + "s", message);
	}

	@Override
	public void run() {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void start() {
		throw new UnsupportedOperationException();
		
	}
}
