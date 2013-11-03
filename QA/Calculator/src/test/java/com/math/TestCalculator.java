package com.math;

import com.grupo13.model.*;
import com.math.calculator.Calculator;

public class TestCalculator extends TestSuite {

	public static void main(String[] args) {
		
		TestCalculator tc = new TestCalculator();
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
		testMinusBug();
		testMultBug();
		testDivideBug();
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
