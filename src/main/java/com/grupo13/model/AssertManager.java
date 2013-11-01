package com.grupo13.model;

import java.util.ArrayList;
import java.util.List;

public class AssertManager {

	private List<TestCase> resultList = new ArrayList<TestCase>();
	private TestCase currentResult = new TestCase();

	public List<TestCase> getResultList() {
		return resultList;
	}

	private boolean isNewCaller(String callerName) {
		return (currentResult.getName().compareTo(callerName) != 0);
	}

	private void restartTestResult(Assertion assertion) {
		String msg = assertion.isOk()?"":assertion.getMessage();
		currentResult = new TestCase(assertion.getCallerMethod(), msg, assertion.isOk());
	}

	public boolean currentTestIsPassing() {
		return currentResult.isOK();
	}

	public void processAssertion(Assertion assertion) {
		createNewTestResult(assertion);
		if (currentTestIsPassing()) {
			updateTestResult(assertion);
		}
	}

	private void updateTestResult(Assertion assertion) {
		if (!assertion.isOk()) {
			currentResult.setMessage(assertion.getMessage());
		}
		currentResult.setOK(assertion.isOk());
		
	}

	private void createNewTestResult(Assertion assertion) {
		if (isNewCaller(assertion.getCallerMethod())){
			pushCurrentTestResult();
			restartTestResult(assertion);
		}
		
	}

	public void pushCurrentTestResult() {
		if (currentResult.isValid()) {
			resultList.add(currentResult);
		}
	}

	public boolean methodPassed(String testName) throws IllegalStateException{
		for (TestCase result : resultList) {
			if (testName.equalsIgnoreCase(result.getName())) {
				return result.isOK();
			}
		}
		throw new IllegalStateException();
	}
	
	public void printResults() {
		System.out.println("Number of tests: " + resultList.size());
		for (TestCase result : resultList) {
			System.out.println(result.toString());

		}
	}

}
