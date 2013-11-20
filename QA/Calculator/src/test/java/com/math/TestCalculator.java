package com.math;

import com.grupo13.model.TestSuite;
import com.grupo13.stores.*;
import com.math.calculator.Calculator;

public class TestCalculator extends TestSuite {

	public static void main(String[] args) {
		TestCalculator tc = new TestCalculator();
		TestCalculator tc2 = new TestCalculator();
		Long timeOut = new Long(1000);

		// Genero y seteo un PersistenceManager
		SerializedObjectManager persistenceManager = new SerializedObjectManager();
		tc.setPersistenceManager(persistenceManager);
		
		/* Le seteo al suite para que corra solo los tests que fallaron
		 * Para setear este atributo en true, previamente debe existir la corrida
		 * persistida. Caso contrario, tirara una exception.
		 */
		tc.setRunOnlyFailedTests(true);
		
		//Anidamiento de suites
		tc.addTestComponent(tc2);
		tc.setRegex(".*Bug.*");
		tc.setTimeOutError(timeOut);
		tc.start();
		
		tc.showTest();
		tc.saveTestResults();
	}

	@Override
	public void run() {
		testAdd();
		testMinus();
		testMult();
		testDivide();

		testAddBug();
		/*
		testMinusBug();
		testMultBug();
		testDivideBug();
		 */
	}

	public void testAdd() {
		Calculator calculator = new Calculator();
		assertEquals(4.0, calculator.addAwithB(2, 2));
	}
	
	public void testAddBug() {
		Calculator calculator = new Calculator();
		assertEquals(4.0, calculator.addAwithBBug(2, 2));
	}
	
	public void testMinus(){
		Calculator calculator = new Calculator();
		assertEquals(0.0, calculator.minusAwithB(2, 2));
	}
	
	public void testMinusBug(){
		Calculator calculator = new Calculator();
		assertEquals(0.0, calculator.minusAwithBBug(2, 2));
	}

	public void testMult(){
		Calculator calculator = new Calculator();
		assertEquals(4.0, calculator.mulAwithB(2, 2));
	}
	
	public void testMultBug(){
		Calculator calculator = new Calculator();
		assertEquals(4.0, calculator.mulAwithBBug(2, 2));
	}
	
	public void testDivide(){
		Calculator calculator = new Calculator();
		assertEquals(1.0, calculator.divideAwithBparts(2, 2));
	}
	
	public void testDivideBug(){
		Calculator calculator = new Calculator();
		assertEquals(4.0, calculator.divideAwithBpartsBug(2, 2));
	}

}
