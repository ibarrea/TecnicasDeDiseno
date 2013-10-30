package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

public class AssertManager {
	TestCase target;
	List<TestResult> resultList;
	String currentCaller = new String("");
	boolean currentMethodFailed;

	public void setTarget(TestCase testCase) {
		target = testCase;

	}

	public void startJob() {
		//Inicializo el array de resultados, donde voy a guardar solo los tests fallidos.
		//Se almacenara solo el 1er fail de cada test.
		resultList = new ArrayList<TestResult>();
		//Guardo si el metodo corriendo actualmente fallo. Si ya fallo omite los siguientes tests.
		currentMethodFailed = false;

		target.run();

	}
	

	public List<TestResult> getResultList() {
		return resultList;
	}

	private boolean isNewCaller(String callerName) {

		if (currentCaller.compareTo(callerName) == 0) {
			return false;
		}
		// Si llega hasta aca es porq es un nuevo caller
		restartCurrentValues(callerName);
		return true;
	}

	private void restartCurrentValues(String callerName) {
		currentCaller = callerName;
		currentMethodFailed = false;
	}

	private boolean checkCallerNameAndStatus(String callerName) {
		boolean isNew = isNewCaller(callerName);
		if (isNew || currentTestIsPassing()) {
			// Sigo corriendo
			return true;
		} else
			// El metodo actual ya fallo en un test anterior, lo ignoro
			return false;
	}

	public boolean currentTestIsPassing() {
		return !currentMethodFailed;
	}

	public void processAssertion(Assertion assertion) {
		//me fijo si tengo que seguir corriendo tests, o si ya fallo el metodo actual
		boolean shouldRun = checkCallerNameAndStatus(assertion.getCallerMethod());
		if (shouldRun) {
			analyzeResultAndUpdateResultList(assertion);
		}
	}

	private void analyzeResultAndUpdateResultList(Assertion assertion) {
		if (isNewCallerMethod(assertion)) {				
			TestResult result = new TestResult(currentCaller, null, true);
			resultList.add(result);
			currentCaller = assertion.getCallerMethod();
		}else if (!assertion.isOk()) {
			currentCaller = assertion.getCallerMethod();
			currentMethodFailed = true;
			TestResult result = new TestResult(currentCaller, assertion.getMessage(), false);
			resultList.add(result);
		}
	}

	private boolean isNewCallerMethod(Assertion assertion) {
		return !assertion.getCallerMethod().equalsIgnoreCase(currentCaller);
	}

	public boolean methodPassed(String testName) throws IllegalStateException{
		for (TestResult result : resultList) {
			if (testName.equalsIgnoreCase(result.getName())) {
				return result.isOK();
			}
		}
		throw new IllegalStateException();
	}

}
