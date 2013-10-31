package com.grupo13;

import com.grupo13.model.TestCase;

public class SampleClientTest extends TestCase {

	public SampleClientTest() {
		super();
		nombre = "EjemploCliente";
		
	}

	@Override
	public void run() {
		// TODO el cliente debe llamar su codigo aca
	}
	
	@Override
	public void setup(){
		
	}
	
	@Override
	public void tearDown(){
		
	}

	public static void main(String[] args) {

		
		(new SampleClientTest()).start();

	}
	
	

}
