package com.grupo13.model;

public abstract class TestComponent {
	
	protected String name;
	protected boolean isOK;
	
	public abstract void run();
	
	public abstract void start();

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
	
//	public void setup(){
//		
//	}
//	
//	public void tearDown(){
//		
//	}

}
