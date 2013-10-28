package com.grupo13.model;

public class Assertion {
	
	private String callerMethod;
	private String message;
	private boolean isOk;
	
	
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
	
	public boolean assertEquals (Object a, Object b){
		return a.equals(b);
	}
	
	

}
