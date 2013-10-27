package com.grupo13.model;

public class TestFail {

	private String messenger;
	private String name;
	
	public TestFail(String name, String messenger){
		this.messenger = messenger;
		this.name = name;
	}
	
	public String getMessenger(){
		return messenger;
	}
	
	public String getName(){
		return name;
	}
}
