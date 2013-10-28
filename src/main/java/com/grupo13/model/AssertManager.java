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
	
	private boolean isNewCaller(String callerName){
		try{
			if (currentCaller.compareTo(callerName) == 0) {
				return false;
			}
		}catch (NullPointerException e){
			//currentCaller es null porq no se uso antes. O sea q es un nuevo caller.
			restartCurrentValues(callerName);
			return true;
		}
		//Si llega hasta aca es porq es un nuevo caller
		restartCurrentValues(callerName);
		return true;
	}
	
	private void restartCurrentValues(String callerName){
		currentCaller = callerName;
		currentMethodFailed = false;
	}

	public void assertEqual(String callerName, int a, int b) {
		boolean shouldRun = checkCallerNameAndStatus(callerName);
		
	}

	public void assertTrue(String callerName, boolean a) {
		boolean shouldRun = checkCallerNameAndStatus(callerName);
	}

	public void assertIsNotNull(String callerName, Object o) {
		boolean shouldRun = checkCallerNameAndStatus(callerName);

	}

	public void assertIsNull(String callerName, Object o) {
		boolean shouldRun = checkCallerNameAndStatus(callerName);

	}

	public boolean getStatus(String testName) {
		//este metodo podria retornar un TestResult o algo asi
		return true;
	}
	
	private boolean checkCallerNameAndStatus(String callerName){
		boolean isNew = isNewCaller(callerName);
		if (!isNew && !currentMethodFailed) {
			//Sigo corriendo
			
			return true;
		}
		else 
			//El metodo actual ya fallo en un test anterior, lo ignoro
			return false;
	}

	
}
