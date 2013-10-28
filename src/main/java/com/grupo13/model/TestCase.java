package com.grupo13.model;


public abstract class TestCase implements Runnable {
	protected String nombre = "TestCase";

	private static AssertManager am = new AssertManager();

	public void start() {
		// creo una dependencia circular! estoy usando el patron mediator.. eso
		// creo..
		System.out.println(getCallerName());
		am.setTarget(this);
		am.startJob();

	}

	public String getCallerName() {
		return nombre;
	}

	public void assertTrue(boolean condition) {
		am.assertTrue(getCallerName(), condition);

	}

}
