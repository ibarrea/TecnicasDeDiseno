package com.grupo13.model;

import java.util.HashMap;
import java.util.Iterator;

import com.grupo13.dto.DtoTestSuite;
import com.grupo13.exception.Grupo13CannotVerifyNonExecutedTestException;
import com.grupo13.exception.Grupo13DuplicateTestException;
import com.grupo13.idto.IDtoTest;
import com.grupo13.iview.IViewTestSuite;
import com.grupo13.report.ReportSaver;
import com.grupo13.view.ViewTestSuite;

public abstract class TestSuite extends TestComponent {

	HashMap<String, TestComponent> components = new HashMap<String, TestComponent>();
	String packageName;
	String regex;

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public TestSuite() {
		super();
		definePackageClassName();
	}

	public void start() {
		setup();
		run();
		startComponents();
		tearDown();
		setExecuted(true);

	}

	public void startComponents() {
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent component = components.get(keySetIterator.next());
			if (testComponentMatchRegex(component) || !component.isTestCase()) {
				component.start();
			}

		}
	}

	public void addTestComponent(TestComponent component) {
		if (components.containsKey(component.getName())) {
			throw new Grupo13DuplicateTestException(component.getName()
					+ " ya existe.");
		}
		components.put(component.getName(), component);
	}

	// devuelve el nombre del methodo que invoca al metodo que usa a este
	// debe ir una cantidad fija de niveles en el stack para traer el dato.
	private String getTestCallerName() {
		final int depthInStack = 4;
		return getMethodName(depthInStack);
	}

	private String getMethodName(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[depth].getMethodName();
	}

	// Asigna el className a el nombre del TestSuite
	// Asigna el el nombre del paquete a packageName
	private void definePackageClassName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		final int depthInStack = 4;
		String temp = ste[depthInStack].getClassName();
		packageName = temp.substring(0, temp.lastIndexOf("."));
		int limitPos = temp.lastIndexOf("$");
		name = temp.substring(limitPos + 1, temp.length());
	}

	// devuleve true si el metodo paso
	// precondicion: el test debe existir. Si no esta, te tira un
	// IllegalStateException
	public boolean verifyTest(String testName) {
		if (components.containsKey(testName)) {
			if (components.get(testName).isExecuted()) {
				return components.get(testName).isOK();
			}
			throw new Grupo13CannotVerifyNonExecutedTestException();
		}
		throw new IllegalStateException();

	}

	private void addAssertionToComponent(Assertion assertion,
			String componentName) {
		TestCase test;
		if (components.containsKey(componentName)) {
			test = (TestCase) components.get(componentName);
		} else {
			test = new TestCase(componentName);
			addTestComponent(test);
		}
		test.getAssertions().add(assertion);
	}

	/*
	 * Asserts: crea un assertion para el metodo que llama (Caller) el resultado
	 * es en cada TestCase del cual proviene
	 */

	public void assertTrue(boolean condition) {
		Assertion assertion = new Assertion();
		assertion.assertTrue(condition);
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void assertFalse(boolean condition) {
		Assertion assertion = new Assertion();
		assertion.assertFalse(condition);
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void assertEquals(Object a, Object b) {
		Assertion assertion = new Assertion();
		assertion.assertEquals(a, b);
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void assertEquals(int a, int b) {
		Assertion assertion = new Assertion();
		assertion.assertEquals(new Integer(a), new Integer(b));
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void assertEquals(float a, float b) {
		Assertion assertion = new Assertion();
		assertion.assertEquals(new Float(a), new Float(b));
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void assertIsNull(Object o) {
		Assertion assertion = new Assertion();
		assertion.assertIsNull(o);
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void assertIsNotNull(Object o) {
		Assertion assertion = new Assertion();
		assertion.assertIsNotNull(o);
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void fail() {
		Assertion assertion = new Assertion();
		assertion.fail();
		addAssertionToComponent(assertion, getTestCallerName());
	}

	public void setup() {

	}

	public void tearDown() {

	}

	public void saveTestResults() {
		IDtoTest dto = new DtoTestSuite(name);
		initializeDTO(dto);
		System.out.println(dto.getMessage(packageName));

		ReportSaver saver = new ReportSaver(dto);
		saver.save();
	}

	public void showTest() {

		IDtoTest dto = new DtoTestSuite(name);
		initializeDTO(dto);

		IViewTestSuite iviewTestSuite = new ViewTestSuite(dto);
		iviewTestSuite.prepareViewTestSuite().showViewTestSuite();
	}

	public void initializeDTO(IDtoTest dto) {
		loadComponentsToDTO(dto, true);
		loadComponentsToDTO(dto, false);
	}

	private void loadComponentsToDTO(IDtoTest dto, boolean applyToTestCases) {
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent test = components.get(keySetIterator.next());
			if (test.isTestCase() == applyToTestCases && test.isExecuted()) {
				test.loadDTO(dto);
			}
		}
	}

	private boolean testComponentMatchRegex(TestComponent test) {
		if (regex == null) {
			return true;
		}
		return test.getName().matches(regex);
	}

	@Override
	public void loadDTO(IDtoTest dto) {
		DtoTestSuite dtoTestSuite2 = new DtoTestSuite(name);
		((DtoTestSuite) dto).add(dtoTestSuite2);
		initializeDTO(dto);

	}
}
