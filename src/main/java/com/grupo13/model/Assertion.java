package com.grupo13.model;

public class Assertion {

	private String callerMethod;
	private String message;
	private boolean isOk;
	private boolean hasError;

	public boolean hasError() {
		return hasError;
	}

	public Assertion setHasError(boolean hasError) {
		this.hasError = hasError;
		return this;
	}

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

	public Assertion setOk(boolean isOk) {
		this.isOk = isOk;
		return this;
	}

	public void updateStatus(boolean assertPass, String msg) {
		setHasError(false).setOk(assertPass).setMessage(msg);
	}
	
	public void updateStatusFail(String msg) {
		setHasError(true).setOk(false).setMessage(msg);
	}

	public void assertEquals(Object a, Object b) {
		try {
			updateStatus(a.equals(b), makeMessage(a.toString(), b.toString()));
		} catch (Exception e) {
			updateStatusFail(e.getMessage());
		}
	}

	private String makeMessage(String expected, String was) {
		return "Expected: <" + expected
				+ "> but was: <" + was+">";
	}

	public void assertTrue(boolean condition) {
		assertEquals(new Boolean(true), new Boolean(condition));

	}

	public void assertIsNotNull(Object obj) {
		try{
			updateStatus(!isNull(obj), makeMessage("Not null", "Null"));
		}catch(Exception e){
			updateStatusFail(e.getMessage());
		}
	}

	public void assertIsNull(Object obj) {
		try{
			updateStatus(isNull(obj),  makeMessage("Null", "Not Null"));
		}catch(Exception e){
			updateStatusFail(e.getMessage());
		}
	}

	private boolean isNull(Object obj) {
		return obj == null;
	}

	public void assertFalse(boolean condition) {
		assertTrue(!condition);
	}

	public void fail() {
		//updateStatus(false, "Failed");
		updateStatusFail("Failed");
	}

}
