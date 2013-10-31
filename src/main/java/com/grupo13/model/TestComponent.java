package com.grupo13.model;

public abstract class TestComponent {
	
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}

	public abstract void run();
	
	void setup(){
		
	}
	
	void tearDown(){
		
	}

		

}
