package com.grupo13.model;

public abstract class TestComponent {
	
	private String name;
	
	public abstract void run();
	
	public abstract void start();

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setup(){
		
	}
	
	public void tearDown(){
		
	}

}
