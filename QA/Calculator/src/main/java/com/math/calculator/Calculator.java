package com.math.calculator;

public class Calculator {
	
	private double accumulator; 
	
	public Calculator(){
		
	}
	
	public double addAwithB(double NumberA, double NumberB){
		return NumberA + NumberB;
	}
	
	public double mulAwithB(double NumberA, double NumberB){
		return NumberA + NumberB;
	}
	
	public double divideAwithBparts(double NumberA, double NumberB){
		return NumberA / NumberB;
	}
	
	public double deductAwithB(double NumberA, double NumberB){
		return NumberA - NumberB;
	}
	
	public void rememberResul(double result){
		accumulator = result;
	}
	
	public double addAwithAccumulator(double NumberA){
		return NumberA + accumulator;
	}
	
	public double deductAwithAccumulator(double NumberA){
		return NumberA - accumulator;
	}
	
	public double mulAwithAccumulator(double NumberA){
		return NumberA * accumulator;
	}
	
	public double divideAwithAccumulatorParts(double NumberA){
		return NumberA / accumulator;
	}
}
