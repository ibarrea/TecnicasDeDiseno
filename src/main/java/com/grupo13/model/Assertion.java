package com.grupo13.model;

public class Assertion {

	private String callerMethod;
	private String message;
	private boolean isOk;

	public Assertion(String callerName) {
		setCallerMethod(callerName);
	}

	public static Assertion createWithCaller(String callerName) {
		return new Assertion(callerName);
	}

	public String getCallerMethod() {
		return callerMethod;
	}

	public void setCallerMethod(String callerMethod) {
		this.callerMethod = callerMethod;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	
	public void updateStatus(boolean condition, String msg){
		setOk(condition);
		setMessage(msg);
	}

	public void assertEquals(Object a, Object b) {
		updateStatus(a.equals(b), "Parameters aren't equal");
	}
	
	public void assertEquals(int a, int b) {
		updateStatus(a == b, "Expected " + a +"but received " +b);
	}
	
	
	public void assertEquals(float a, float b) {
		updateStatus(a == b, "Expected " + a +"but received " +b);
	}

	public void assertTrue(boolean condition) {
		updateStatus(condition, "Expected " + condition +"but received " +!condition);

	}

	public void assertIsNotNull(String callerName, Object obj) {
		updateStatus(!isNull(obj), "Expected <Not null> but received <null>");
		setOk(!isNull(obj));

	}

	public void assertIsNull(String callerName, Object obj) {
		setOk(isNull(obj));

	}

	private boolean isNull(Object obj) {
		return obj == null;
	}

	public void assertFalse(boolean condition) {
		assertTrue(!condition);
		
	}

}
