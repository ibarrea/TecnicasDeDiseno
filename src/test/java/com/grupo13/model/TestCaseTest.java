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
		Assert.assertEquals("Ok!", example.getMessage());
	}
	
	@Test
	public void getMessageTestCaseFailedShowsExpected() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assertion assertion = new Assertion();
		assertion.assertTrue(false);
		example.getAssertions().add(assertion);
		example.start();
		Assert.assertEquals("Expected: <true> but was: <false>", example.getMessage());
	}
	
	@Test
	public void getMessageTestCaseErrorIsException() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assertion assertion = new Assertion();
		assertion.assertEquals(null, null);
		example.getAssertions().add(assertion);
		example.start();
		Assert.assertEquals("java.lang.NullPointerException", example.getMessage());
	}
	
	
	@Test
	public void formatCheckTestCaseLongNameToString() {
		String anyTestName = "thisIsAVeryVeryVeryVeryVeryVeryVeryVeryLongLongLongMethodName";
		TestCase example = new TestCase(anyTestName);
		Assert.assertEquals("thisIsAVeryVeryVeryVeryVeryVeryVeryVeryL",
				example.toString().trim().substring(0, 40));
	}
	
	@Test
	public void isTestCaseReturnsTrue() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assert.assertTrue(example.isTestCase());
	}
	
	
	@Test
	public void toXMLElementReturnsNotNullWhenIsNewTestCase() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assert.assertNotNull(example.toXMLElement());
	}
	
	@Test
	public void toXMLElementReturnsNotNullWhenTestCaseHasErrors() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		example.setError(true);
		Assert.assertNotNull(example.toXMLElement());
	}
	
	
	@Test
	public void toXMLElementReturnsNotNullWhenTestCaseFails() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assertion assertion = new Assertion();
		assertion.assertTrue(false);
		example.getAssertions().add(assertion);
		example.start();
		Assert.assertNotNull(example.toXMLElement());
	}
	
	@Test
	public void getTagsReturnsNotNullWhenIsNewTestCase() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		Assert.assertNotNull(example.getTags());
	}
	
	@Test
	public void getTagsContainsTagWhenAdded() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		example.addTag("SLOW");
		Assert.assertNotNull(example.getTags().contains("SLOW"));
	}
	
	@Test
	public void getTagsContainsTagIsCaseInsensitiveWhenAdded() {
		String anyTestName = "anyTestName";
		TestCase example = new TestCase(anyTestName);
		example.addTag("SLOW");
		Assert.assertNotNull(example.getTags().contains("slow"));
	}

}
