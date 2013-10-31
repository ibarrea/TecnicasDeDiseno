package com.grupo13.model;

import com.grupo13.iview.IViewTestCase;
import com.grupo13.view.ViewTestCase;

public abstract class TestCase implements ITestCase {
	protected String nombre = "TestCase";

	private static AssertManager am;

	private String getMethodName(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[depth].getMethodName();
	}

	public void start() {
		setup();
		am = new AssertManager();
		run();
		am.pushCurrentTestResult();
		tearDown();
		showTest();
	}

	public String getCallerName() {
		final int depthInStack = 4;
		return getMethodName(depthInStack);
	}

	// devuleve true si el metodo paso
	// precondicion: el test debe existir. Si no esta, te tira un IllegalStateException
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
	
	public void assertEquals(int a, int b) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertEquals(new Integer(a),new Integer(b));
		am.processAssertion(assertion);
	}
	
	public void assertEquals(float a, float b) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertEquals(new Float(a),new Float(b));
		am.processAssertion(assertion);
	}
	
	public void fail() {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.fail();
		am.processAssertion(assertion);
	}
	
	private void showTest(){
		IViewTestCase iviewTestCase = new ViewTestCase(am.getResultList());
		iviewTestCase.prepareViewTestCase().showViewTestCase();
	}
	
	
	public void setup(){
		
	}
	
	public void tearDown(){
		
	}
	

}
