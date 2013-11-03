package com.grupo13.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;

import com.grupo13.mock.dto.DtoTestSuite;
import com.grupo13.mock.idto.IDtoTest;
import com.grupo13.iview.IViewTestCase;
import com.grupo13.view.ViewTestCase;

public abstract class TestSuite extends TestComponent {

	HashMap<String, TestComponent> components = new HashMap<String, TestComponent>();
	String packageName;

	public TestSuite() {
		super();
		definePackageClassName();
	}

	public void start() {
		setup();
		run();
		startComponents();
		tearDown();

	}

	public void startComponents() {
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			components.get(keySetIterator.next()).start();
		}
	}

	public void addTestComponent(TestComponent component) {
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
		System.out.println(temp);
		name = temp.substring(limitPos + 1, temp.length());
	}

	// devuleve true si el metodo paso
	// precondicion: el test debe existir. Si no esta, te tira un
	// IllegalStateException
	public boolean verifyTest(String testName) {
		if (components.containsKey(testName)) {
			return components.get(testName).isOK();
		}
		throw new IllegalStateException();

	}

	private void addAssertionToComponent(Assertion assertion,
			String componentName) {
		TestCase test;
		if (components.containsKey(componentName)) {
			// TODO if is finished throw testCalled is repetido
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
	
	public void saveTestResults(){
		IDtoTest dto = new DtoTestSuite(name);
		initializeDTO(dto);
		System.out.println(dto.getMessage(packageName));

		PrintWriter writer = null;
		java.util.Date date= new java.util.Date();
		try {
			String fileName = "testResult-"+ new Timestamp(date.getTime())+ ".txt";
			File file = new File("testLogs/" + fileName);
			file.getParentFile().mkdirs();
			writer = new PrintWriter(file, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println("Run: " + dto.getNumberOfTestCase());
		writer.println("Errors: " + dto.getNumberOfErrors());
		writer.println("Failures: " + dto.getNumberOfFailures());
		writer.println(dto.getMessage(packageName));
		writer.close();
	}

	public void showTest() {

		IDtoTest dto = new DtoTestSuite(name);
		initializeDTO(dto);

		// IViewTestCase iviewTestCase = new
		// ViewTestCase(assertManager.getResultList());
		// iviewTestCase.prepareViewTestCase().showViewTestCase();
	}

	public void initializeDTO(IDtoTest dto) {
		loadComponentsToDTO(dto, true);
		loadComponentsToDTO(dto, false);
	}

	private void loadComponentsToDTO(IDtoTest dto, boolean applyToTestCases) {
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent test = components.get(keySetIterator.next());
			if (test.isTestCase() == applyToTestCases) {
				test.loadDTO(dto);
			}
		}
	}

	@Override
	public void loadDTO(IDtoTest dto) {
		DtoTestSuite dtoTestSuite2 = new DtoTestSuite(name);
		((DtoTestSuite) dto).add(dtoTestSuite2);
		initializeDTO(dto);

	}
}
