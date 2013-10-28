package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

public class AssertManager {
	TestCase target;
	List<TestResult> resultList;
	String currentCaller;
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

	private boolean isNewCaller(String callerName) {
		// try{
		// if (currentCaller.compareTo(callerName) == 0) {
		// return false;
		// }
		// }catch (NullPointerException e){
		// //currentCaller es null porq no se uso antes. O sea q es un nuevo
		// caller.
		// restartCurrentValues(callerName);
		// return true;
		// }
		//
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
		if (!isNew && currentTestIsPassing()) {
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
		boolean shouldRun = checkCallerNameAndStatus(assertion.getCallerMethod());
		if (shouldRun) {
			// TODO
		}

	}

	public boolean methodPassed(String testName) {
		// TODO buscar el la lista y devolver si paso bien
		return true;
	}

}
