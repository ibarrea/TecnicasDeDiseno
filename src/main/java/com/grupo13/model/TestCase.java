package com.grupo13.model;


public abstract class TestCase implements Runnable {
	protected String nombre = "TestCase";

	private static AssertManager am = new AssertManager();
	
	public String getMethodName(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		//return ste[ste.length - 1 - depth].getMethodName();
		return ste[depth].getMethodName();
	}

	public void start() {
		// creo una dependencia circular! estoy usando el patron mediator.. eso
		// creo..
		System.out.println(getCallerName());
		am.setTarget(this);
		am.startJob();

	}

	public String getCallerName() {
		//TODO ajustar el depth al probar con casos reales
		final int depth = 3;
		return getMethodName(depth);
	}

	public void assertTrue(boolean condition) {
		am.assertTrue(getCallerName(), condition);

	}


}
