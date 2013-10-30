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

	public void updateStatus(boolean assertPass, String msg) {
		setOk(assertPass);
		setMessage(msg);
	}

	public void assertEquals(Object a, Object b) {
		if (!isNull(a) && !isNull(b)) {
			updateStatus(a.equals(b), makeMessage(a.toString(), b.toString()));
		} else {
			updateStatus(false, "NullPointer Exception occured.");
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
		updateStatus(!isNull(obj), makeMessage("Not null", "Null"));

	}

	public void assertIsNull(Object obj) {
		updateStatus(isNull(obj),  makeMessage("Null", "Not Null"));

	}

	private boolean isNull(Object obj) {
		return obj == null;
	}

	public void assertFalse(boolean condition) {
		assertTrue(!condition);

	}

	public void fail() {
		updateStatus(false, "Failed");
		
	}

}
