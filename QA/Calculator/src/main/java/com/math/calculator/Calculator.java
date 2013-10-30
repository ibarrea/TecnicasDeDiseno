package com.math.calculator;

public class Calculator {
	
	private double accumulator; 
	
	public Calculator(){
		
	}
	
	public double addAwithB(double NumberA, double NumberB){
		return NumberA + NumberB;
	}
	
	public double addAwithBBug(double NumberA, double NumberB){
		return NumberA + NumberB + 1.0;
	}
	
	public double mulAwithB(double NumberA, double NumberB){
		return NumberA * NumberB;
	}
	
	public double mulAwithBBug(double NumberA, double NumberB){
		return NumberA * NumberB * 2;
	}
	
	public double divideAwithBparts(double NumberA, double NumberB){
		return NumberA / NumberB;
	}
	
	public double divideAwithBpartsBug(double NumberA, double NumberB){
		return (NumberA / NumberB) + 1.0;
	}
	
	public double minusAwithB(double NumberA, double NumberB){
		return NumberA - NumberB;
	}
	
	public double minusAwithBBug(double NumberA, double NumberB){
		return NumberA - NumberB - 1.0;
	}
	
	public void rememberResul(double result){
		accumulator = result;
	}
	
	public double addAwithAccumulator(double NumberA){
		return NumberA + accumulator;
	}
	
	public double minusAwithAccumulator(double NumberA){
		return NumberA - accumulator;
	}
	
	public double mulAwithAccumulator(double NumberA){
		return NumberA * accumulator;
	}
	
	public double divideAwithAccumulatorParts(double NumberA){
		return NumberA / accumulator;
	}
}
