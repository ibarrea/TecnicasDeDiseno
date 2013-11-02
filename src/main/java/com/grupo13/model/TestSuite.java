package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

import com.grupo13.iview.IViewTestCase;
import com.grupo13.view.ViewTestCase;

public abstract class TestSuite extends TestComponent {

	private AssertManager assertManager;
	private List<TestComponent> components = new ArrayList<TestComponent>();

	public void start() {
		setup();
		assertManager = new AssertManager();
		run();
		pushRemainingTests();
		tearDown();
		for (TestComponent component: components) {
			component.start();
		}
	}
	
	public void addTestComponent(TestComponent component){
		components.add(component);
	}

	private void pushRemainingTests() {
		assertManager.pushCurrentTestResult();
	}
	
	public void printResults() {
		assertManager.printResults();
	}
	
	// devuelve el nombre del methodo que invoca al metodo que usa a este
	// debe ir una cantidad fija de niveles en el stack para traer el dato.
	private String getCallerName() {
		final int depthInStack = 4;
		return getMethodName(depthInStack);
	}
	
	private String getMethodName(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[depth].getMethodName();
	}

	// devuleve true si el metodo paso
	// precondicion: el test debe existir. Si no esta, te tira un IllegalStateException
	public boolean verifyTest(String testName) {
		return assertManager.methodPassed(testName);

	}

	/* Asserts: crea un assertion para el metodo que llama (Caller)
	   el resultado es mantenido por el assertManager */
	
	public void assertTrue(boolean condition) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertTrue(condition);
		assertManager.processAssertion(assertion);
	}
	
	public void assertFalse(boolean condition) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertFalse(condition);
		assertManager.processAssertion(assertion);
	}
	
	public void assertEquals(Object a, Object b) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertEquals(a,b);
		assertManager.processAssertion(assertion);
	}
	
	public void assertEquals(int a, int b) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertEquals(new Integer(a),new Integer(b));
		assertManager.processAssertion(assertion);
	}
	
	public void assertEquals(float a, float b) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertEquals(new Float(a),new Float(b));
		assertManager.processAssertion(assertion);
	}
	
	public void assertIsNull(Object o) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertIsNull(o);
		assertManager.processAssertion(assertion);
	}
	
	public void assertIsNotNull(Object o) {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.assertIsNotNull(o);
		assertManager.processAssertion(assertion);
	}
	
	public void fail() {
		Assertion assertion = Assertion.createWithCaller(getCallerName());
		assertion.fail();
		assertManager.processAssertion(assertion);
	}


	public void setup(){
		
	}
	
	public void tearDown(){
		
	}
	
	public void showTest(){
		
		IViewTestCase iviewTestCase = new ViewTestCase(assertManager.getResultList());
		iviewTestCase.prepareViewTestCase().showViewTestCase();
	}

}
