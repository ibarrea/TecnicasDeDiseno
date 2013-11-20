package com.grupo13.model;

import java.beans.PersistenceDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jdom.Element;

import com.grupo13.exception.CannotVerifyNonExecutedTestException;
import com.grupo13.exception.DuplicateTestException;
import com.grupo13.results.*;
import com.grupo13.stores.*;

/* TestSuite: Clase de la cual debe heredar el cliente para poder usar el
 * framework de tests. Permite definir m�todos setup() y tearDown().
 * Se debe redefinir el metodo run().
 * Puede incluir TestCases u otros TestSuites, para esto se usa el patr�n Composite. 
 * */

public abstract class TestSuite extends TestComponent {
	HashMap<String, TestComponent> components = new HashMap<String, TestComponent>();
	String packageName;
	String regex;
	List<String> tagsToExecute;
	List<String> testsToSkip;
	
	int countTests, countError, countFailures, countSkipped;

	public void addTagToExecute(String tag){
		tagsToExecute.add(tag);
	}
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setRegex(String regex) {
		this.regex = regex;
	}

	public TestSuite() {
		super();
		tagsToExecute = new ArrayList<String>();
		testsToSkip = new ArrayList<String>();
		countTests = countError = countFailures = countSkipped = 0;
		superSuiteName = new String("");
		runOnlyFailedTests = false;
		definePackageClassName();
	}

	public void start() {
		if (getRunOnlyFailedTests()) {
			startFailed();
		}
		else {
			startAll();
		}
	}
	
	private void startAll() {
		startTimer();
		setup();
		run();
		startComponents();
		tearDown();
		setExecuted(true);
		endTimer();
		show();
	}
	
	private void startFailed() {
		PersistenceManager persistenceManager = getPersistenceManager();
		TestComponent testSuite = persistenceManager.loadResult();
		testSuite.start();
	}
	
	private void show() {
		ViewRealTime.INSTANCE.println(this);
	}

	private void startComponents() {
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent component = components.get(keySetIterator.next());
			if (shouldSkip(component)) {
				component.skip();
			} else {
				component.start();
			}
			updateCounts(component);

		}
	}

	private boolean shouldSkip(TestComponent comp) {
		return testsToSkip.contains(comp.getName()) ||
				!(comp.matches(regex) && comp.matches(tagsToExecute)) || 
				runOkOnPreviousResult();
	}

	private void updateCounts(TestComponent component) {
		countTests += component.countTests();
		countError += component.countErrors();
		countFailures += component.countFailures();
		countSkipped += component.countSkipped();
	}
	
	public void addTestComponent(TestComponent component) {
		if (components.containsKey(component.getName())) {
			throw new DuplicateTestException(component.getName()
					+ " already exists.");
		}
		components.put(component.getName(), component);
		component.setSuperSuiteName(getName());
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
		int limitPos = (temp.lastIndexOf("$")>temp.lastIndexOf("."))?temp.lastIndexOf("$"):temp.lastIndexOf(".");
		packageName = temp.substring(0, temp.lastIndexOf("."));
		
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
			throw new CannotVerifyNonExecutedTestException();
		}
		throw new IllegalStateException();

	}

	private TestCase getComponent(String componentName) {
		TestCase test;
		if (components.containsKey(componentName)) {
			test = (TestCase) components.get(componentName);
		} else {
			test = new TestCase(componentName, getName());
			//test.setSuperSuiteName(getName());
			addTestComponent(test);
		}
		return test;
	}
	
	public void skipTest(String componentName){
		testsToSkip.add(componentName);
	}
	
	private void addAssertionToComponent(Assertion assertion, String componentName) {
		TestCase test = getComponent(componentName);
		test.setTimeOutError(this.timeOutError);
		test.getAssertions().add(assertion);
	}
	
	public void tagTest(String tagName) {
		TestCase test = getComponent(getTestCallerName());
		test.addTag(tagName);
	}
	
	public void tagTest(String componentName, String tagName) {
		TestCase test = getComponent(componentName);
		test.addTag(tagName);
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
		ResultOutputter plainTextSaver = new PlainTextSaver();
		plainTextSaver.setData(this);
		plainTextSaver.produceResult();
		
		ResultOutputter xmlSaver = new XMLSaver();
		xmlSaver.setData(this);
		xmlSaver.produceResult();

		PersistenceManager persistenceManager = getPersistenceManager(); 
		if (null != persistenceManager) {
			// Si tengo seteado un PersistenceManager, lo invoco
			persistenceManager.setData(this);
			persistenceManager.storeResult();			
		}

	}

	public void showTest() {
		ResultOutputter resultViewer = new ResultViewer();
		resultViewer.setData(this);
		resultViewer.produceResult();
	}
	
	public String toString() {
		String result = getFullName() + "  ( " + ellapsedTime + " ms )";
		result +=  "\n" + testCasesToString() + testSuitesToString();
		return result;
	}

	private String getFullName() {
		String result = new String(packageName + ".");
		result += getSuperSuiteName().isEmpty() ? "" : getSuperSuiteName() + "."; 
		result += getName();
		return result;
	}

	private String testSuitesToString() {
		String result = new String();
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent test = components.get(keySetIterator.next());
			if (!test.isTestCase()) {
				((TestSuite)test).setSuperSuiteName(getName());
				result += test.toString() + "\n";
			}
		}
		return result;
	}

	private String testCasesToString() {
		String result = new String();
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent test = components.get(keySetIterator.next());
			if (test.isTestCase() && test.isExecuted()) {
				result += "\t" + test.toString() + "\n";
			}
		}
		return result;
	}
	
	@Override
	public Integer countTests() {
		return countTests;
	}

	@Override
	public Integer countErrors() {
		return countError;
	}

	@Override
	public Integer countFailures() {
		return countFailures;
	}

	@Override
	public Integer countSkipped() {
		return countSkipped;
	}
	
	@Override
	public void skip() {
		skipTest(getTestCallerName());
	}
	
	@Override
	public Element toXMLElement() {
		Element element = new Element("testsuite");
		element.setAttribute("name", getFullName());
		element.setAttribute("package", packageName);
		element.setAttribute("tests", countTests().toString());
		element.setAttribute("failures", countFailures().toString());
		element.setAttribute("errors", countErrors().toString());
		element.setAttribute("time", ellapsedTime.toString());
		Iterator<String> keySetIterator = components.keySet().iterator();
		while (keySetIterator.hasNext()) {
			TestComponent component = components.get(keySetIterator.next());
			element.addContent(component.toXMLElement());
		}
		return element;
	}
}