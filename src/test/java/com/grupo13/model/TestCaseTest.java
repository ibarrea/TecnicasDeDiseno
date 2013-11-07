package com.grupo13.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCaseTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void runInTestCaseThrowsUnsupportedOperationException() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		exception.expect(UnsupportedOperationException.class);
		example.run();
	}

	@Test
	public void formatCheckTestCasePassedToString() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assert.assertEquals(
				"anyTestName                             |Pass      |Ok!",
				example.toString().trim());
	}
	
	@Test
	public void formatCheckTestCaseFailedToString() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assertion assertion = new Assertion();
		assertion.assertTrue(false);
		example.getAssertions().add(assertion);
		example.start();
		Assert.assertEquals(
				"anyTestName                             |Failed    |Expected: <true> but was: <false>",
				example.toString().trim());
	}
	
	@Test
	public void formatCheckTestCaseErrorToString() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assertion assertion = new Assertion();
		assertion.assertEquals(null, null);
		example.getAssertions().add(assertion);
		example.start();
		Assert.assertEquals(
				"anyTestName                             |Error     |java.lang.NullPointerException",
				example.toString().trim());
	}

}
