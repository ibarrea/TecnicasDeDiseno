package com.grupo13.model;

public abstract class TestCase implements Runnable {
	protected String nombre = "TestCase";

	private static AssertManager am = new AssertManager();

	public String getMethodName(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		// return ste[ste.length - 1 - depth].getMethodName();
		return ste[depth].getMethodName();
	}

	public void start() {
		// creo una dependencia circular!
		// estoy usando el patron mediator.. eso creo
		// System.out.println(getCallerName());
		System.out.println("Running tests..");
		am.setTarget(this);
		am.startJob();

	}

	public String getCallerName() {
		// TODO ajustar el depth al probar con casos reales
		final int depth = 3;
		return getMethodName(depth);
	}

	// devuleve true si el metodo paso
	// precondicion: el test debe existir
	public boolean verifyTest(String testName) {
		return am.methodPassed(testName);

	}

	/* Asserts: crea un assertion para el metodo que llama (Caller)
	   el resultado es mantenido por el assertManager */
	
	public void assertTrue(boolean condition) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertTrue(condition);
		am.processAssertion(assertion);
	}
	
	public void assertFalse(boolean condition) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertFalse(condition);
		am.processAssertion(assertion);
	}
	
	public void assertEquals(Object a, Object b) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertEquals(a,b);
		am.processAssertion(assertion);
	}

}
