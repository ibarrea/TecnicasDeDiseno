package com.math;

import com.grupo13.model.TestCase;
import com.math.calculator.Calculator;


public class TestCalculator extends TestCase{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		testAdd();
	}
	
	public void testAdd(){
		Calculator calculator = new Calculator();
		assertEquals(calculator.addAwithB(2, 2), 4);
	}

}
