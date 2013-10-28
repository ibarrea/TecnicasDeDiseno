package com.grupo13.model;


public class AssertManager {
	TestCase target;

	public void setTarget(TestCase testCase) {
		target = testCase;

	}

	public void startJob() {
		// hacer lo que sea necesario
		target.run();

	}

	public void assertEqual(String callerName, int a, int b) {
		// TODO Hacer lo que habiamos planeado

	}

	public void assertTrue(String callerName, boolean a) {
		// TODO Hacer lo que habiamos planeado
	}

	public void assertIsNotNull(String callerName, Object o) {
		// TODO Hacer lo que habiamos planeado

	}

	public void assertIsNull(String callerName, Object o) {
		// TODO Hacer lo que habiamos planeado

	}

	public boolean getStatus(String testName) {
		//este metodo podria retornar un TestResult o algo asi
		return true;
	}

}
