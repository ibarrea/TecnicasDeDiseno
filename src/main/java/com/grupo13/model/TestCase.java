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
		//System.out.println(getCallerName());
		System.out.println(getCallerName());
		am.setTarget(this);
		am.startJob();

	}

	public String getCallerName() {
		// TODO ajustar el depth al probar con casos reales
		final int depth = 3;
		return getMethodName(depth);
	}

	// ingresa un assert del metodo que llama
	// el resultado es mantenido por el assertManager
	public void assertTrue(boolean condition) {
		am.assertTrue(getCallerName(), condition);

	}

	// devuleve true si el metodo existe y esta pasando los tests
	public boolean isPassing(String testName) {
		// Ignacio fijate si es mejor que este metodo devuelva un
		// objeto TestResult para que yo chequee si el metodo existe
		// y no tener que devolver true o false sin saber bien que es
		return am.getStatus(testName);

	}

}
