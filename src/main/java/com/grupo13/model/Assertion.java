package com.grupo13.model;

/* Clase Assertion: Almacena los resultados de cada assert realizado
 * por cada test cliente.
 * */

public class Assertion {

	private String message;
	private boolean isOk;
	private boolean hasError;

	public boolean hasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
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
		try {
			updateStatus(a.equals(b), makeMessage(a.toString(), b.toString()));
		} catch (Exception e) {
			setHasError(true);
			updateStatus(false, e.toString());
		}
	}

	private String makeMessage(String expected, String was) {
		return "Expected: <" + expected + "> but was: <" + was + ">";
	}

	public void assertTrue(boolean condition) {
		assertEquals(new Boolean(true), new Boolean(condition));
	}

	public void assertIsNotNull(Object obj) {
		updateStatus(!isNull(obj), makeMessage("Not null", "Null"));
	}

	public void assertIsNull(Object obj) {
		updateStatus(isNull(obj), makeMessage("Null", "Not Null"));
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
