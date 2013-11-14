package com.grupo13.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;




import com.grupo13.exception.CannotVerifyNonExecutedTestException;
import com.grupo13.exception.DuplicateTestException;

public class TestSuiteTest {

	private TestSuite test1;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private class TestSuite1 extends TestSuite {

		public void exampleFailTest() {
			fail();
		}

		public void assertTrueTest() {
			assertTrue(true);
		}

		public void assertTrueTestFail() {
			assertTrue(false);
		}

		public void assertFalseTest() {
			assertFalse(false);
		}

		public void assertFalseTestFail() {
			assertFalse(true);
		}

		public void assertTruePassingAndFailTest() {
			assertTrue(true);
			fail();
		}

		public void assertEqualsObjectsTestThatShouldPass() {
			assertEquals("Hola", "Hola");
		}

		public void assertEqualsObjectsTestThatShouldntPass() {
			assertEquals("Hola", "Chau");
		}

		public void equalsFailIf1stParamIsNullObject() {
			String objectString = null;
			assertEquals(objectString, "Chau");
		}

		public void equalsFailIf2ndParamIsNullObject() {
			String objectString = null;
			assertEquals("Hello", objectString);
		}

		public void equalsFailIfReceiveBothNullObjects() {
			String objectString = null;
			assertEquals(objectString, objectString);
		}

		public void assertIsNullTestThatShouldPass() {
			String objectString = null;
			assertIsNull(objectString);
		}

		public void assertIsNullTestThatShouldntPass() {
			String objectString = new String("Hello world");
			assertIsNull(objectString);
		}

		public void assertIsNotNullTestThatShouldPass() {
			String objectString = new String("Hello world");
			assertIsNotNull(objectString);
		}

		public void assertIsNotNullTestThatShouldntPass() {
			String objectString = null;
			assertIsNotNull(objectString);
		}

		public void assertEqualsIntTestThatShouldPass() {
			int a = 45;
			assertEquals(a, a);
		}

		public void assertEqualsIntTestThatShouldntPass() {
			int a = 23;
			int b = 1988;
			assertEquals(a, b);
		}

		public void assertEqualsFloatTestThatShouldPass() {
			float a = (float) 23.7;
			assertEquals(a, a);
		}

		public void assertEqualsFloatTestThatShouldntPass() {
			float a = (float) 23.7;
			float b = (float) 23.6;
			assertEquals(a, b);
		}

		public void veryLongLongMethodNameThatExceedMaximunShowablewInResulstsexampleFailTest() {
			fail();
		}
		
		public void doubleAssertEqualsFloatTestThatShouldPass() {
			float a = (float) 23.7;
			assertEquals(a, a);
			float b = (float)54.94;
			assertEquals(b, b);
		}
		
		public void doubleAssertEqualsFloatTestThatShouldntPass() {
			float a = (float) 23.7;
			assertEquals(a, a);
			float b = (float)54.94;
			assertEquals(b, a);
		}
		
		public void exampleInlineSkippedTest() {
			skip();
			fail();
		}

		public void run() {
			// booleans
			assertTrueTest();
			assertTrueTestFail();
			assertFalseTest();
			assertFalseTestFail();

			// objects
			assertEqualsObjectsTestThatShouldPass();
			assertEqualsObjectsTestThatShouldntPass();
			assertIsNullTestThatShouldPass();
			assertIsNullTestThatShouldntPass();
			assertIsNotNullTestThatShouldPass();
			assertIsNotNullTestThatShouldntPass();
			equalsFailIf1stParamIsNullObject();
			equalsFailIf2ndParamIsNullObject();
			equalsFailIfReceiveBothNullObjects();

			// floats
			assertEqualsFloatTestThatShouldPass();
			assertEqualsFloatTestThatShouldntPass();
			doubleAssertEqualsFloatTestThatShouldPass();
			doubleAssertEqualsFloatTestThatShouldntPass();
			// integers
			assertEqualsIntTestThatShouldntPass();
			assertEqualsIntTestThatShouldPass();

			// fail
			exampleFailTest();
			veryLongLongMethodNameThatExceedMaximunShowablewInResulstsexampleFailTest();

			// combined tests
			assertTruePassingAndFailTest();
			
			//skip
			exampleInlineSkippedTest();

		}

	}

	private class TestSuite2 extends TestSuite {

		public void anotherFailTest() {
			fail();
		}

		public void anotherAssertTrueTest() {
			assertTrue(true);
		}

		public void run() {
			// second level depth tests
			anotherFailTest();
			anotherAssertTrueTest();

		}

	}

	@Before
	public void setup() {
		test1 = new TestSuite1();
		TestComponent test2 = new TestSuite2();
		test1.addTestComponent(test2);
		test1.start();
	}

	@Test
	public void existingTestIsPassingIfItsAssertTrueDontFail() {

		Assert.assertTrue(test1.verifyTest("assertTrueTest"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertTrueFail() {

		Assert.assertFalse(test1.verifyTest("assertTrueTestFail"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertFalseDontFail() {

		Assert.assertTrue(test1.verifyTest("assertFalseTest"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertFalseFail() {

		Assert.assertFalse(test1.verifyTest("assertFalseTestFail"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualObjectDontFail() {

		Assert.assertTrue(test1.verifyTest("assertEqualsObjectsTestThatShouldPass"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertEqualObjectFail() {

		Assert.assertFalse(test1.verifyTest("assertEqualsObjectsTestThatShouldntPass"));
	}

	@Test
	public void testIsntPassingIfItsAssertNullFail() {

		Assert.assertFalse(test1.verifyTest("assertIsNullTestThatShouldntPass"));
	}

	@Test
	public void testIsPassingIfItsAssertNullPass() {

		Assert.assertTrue(test1.verifyTest("assertIsNullTestThatShouldPass"));
	}

	@Test
	public void testIsntPassingIfItsAssertNotNullFail() {

		Assert.assertFalse(test1.verifyTest("assertIsNotNullTestThatShouldntPass"));
	}

	@Test
	public void testIsPassingIfItsAssertNotNullPass() {

		Assert.assertTrue(test1.verifyTest("assertIsNotNullTestThatShouldPass"));
	}

	@Test
	public void testIsPassingIfItsAssertEqualIntDontFail() {

		Assert.assertTrue(test1.verifyTest("assertEqualsIntTestThatShouldPass"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertEqualIntFail() {

		Assert.assertFalse(test1.verifyTest("assertEqualsIntTestThatShouldntPass"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualFloatDontFail() {

		Assert.assertTrue(test1.verifyTest("assertEqualsFloatTestThatShouldPass"));
	}
	
	@Test
	public void testDoubleAssertEqualsFloatShouldPass() {
		
		Assert.assertTrue(test1.verifyTest("doubleAssertEqualsFloatTestThatShouldPass"));
	}
	
	@Test
	public void testDoubleAssertEqualsFloatShouldntPass() {
		
		Assert.assertFalse(test1.verifyTest("doubleAssertEqualsFloatTestThatShouldntPass"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertEqualFloatFail() {

		Assert.assertFalse(test1.verifyTest("assertEqualsFloatTestThatShouldntPass"));
	}

	@Test
	public void testIsntPassingIfItsAssertEqualReceiveNullObjectAs1stParam() {

		Assert.assertFalse(test1.verifyTest("equalsFailIf1stParamIsNullObject"));
	}

	@Test
	public void testIsntPassingIfItsAssertEqualReceiveNullObjectAs2stParam() {

		Assert.assertFalse(test1.verifyTest("equalsFailIf2ndParamIsNullObject"));
	}

	@Test
	public void testIsntPassingIfItsAssertEqualReceiveBothNullObjects() {

		Assert.assertFalse(test1.verifyTest("equalsFailIfReceiveBothNullObjects"));
	}

	@Test
	public void verifyTestThatExecuteFailReturnsFalse() {

		Assert.assertFalse(test1.verifyTest("exampleFailTest"));
	}
	
	@Test
	public void tooLongTestsNameAreVerifiedCorrectly() {

		Assert.assertFalse(test1.verifyTest("veryLongLongMethodNameThatExceedMaximunShowablewInResulstsexampleFailTest"));
	}

	@Test
	public void twoAssertsInTestsAssertTruePassingAndFailShoudntPass() {

		Assert.assertFalse(test1.verifyTest("assertTruePassingAndFailTest"));
	}

	@Test
	public void throwsIllegalStateExceptionWhenTestDoesntExists() {
		String nonExistingTest = "nonExistingTest";
		exception.expect(IllegalStateException.class);
		test1.verifyTest(nonExistingTest);
	}
	
	@Test
	public void addingExistingTestNameThrowsDuplicateTestException() {
		String existingTestCaseNameShouldCrashIfAdded = "assertTrueTest";
		TestCase example = new TestCase(existingTestCaseNameShouldCrashIfAdded);
		exception.expect(DuplicateTestException.class);
		test1.addTestComponent(example);
	}
	
	@Test
	public void newTestNameAddedToSuiteIsOk() {
		String nonExistingTest = "nonExistingTest";
		TestCase example = new TestCase(nonExistingTest);
		test1.addTestComponent(example);
		Assert.assertTrue(example.isOK());
	}
	
	@Test
	public void addingExistingTestSuiteNameThrowsDuplicateTestException() {
		String existingTestSuiteNameShouldCrashIfAdded = "TestSuite2";
		TestComponent example = new TestSuite1();
		example.setName(existingTestSuiteNameShouldCrashIfAdded);
		exception.expect(DuplicateTestException.class);
		test1.addTestComponent(example);
	}
	
	@Test
	public void addingNewTestSuiteNameToSuiteIsOk() {
		String nonExistingSuite = "TestSuite200";
		TestComponent example = new TestSuite1();
		example.setName(nonExistingSuite);
		test1.addTestComponent(example);
		Assert.assertTrue(example.isOK());
	}
	
	@Test
	public void nonMatchingTestCannotBeVerified() {
		TestSuite anotherTest = new TestSuite1();
		anotherTest.setRegex("(.*)Int(.*)");
		anotherTest.start();
		String existingTestNameNotMatchingRegex = "assertIsNullTestThatShouldPass";
		exception.expect(CannotVerifyNonExecutedTestException.class);
		Assert.assertTrue(anotherTest.verifyTest(existingTestNameNotMatchingRegex));
	}
	
	@Test
	public void matchingTestCanBeVerified() {
		TestSuite anotherTest = new TestSuite1();
		anotherTest.setRegex("(.*)IsNull(.*)");
		anotherTest.start();
		String existingTestNameNotMatchingRegex = "assertIsNullTestThatShouldPass";
		Assert.assertTrue(anotherTest.verifyTest(existingTestNameNotMatchingRegex));
	}
	
	@Test
	public void suitesAreNTExecutedIfTheyNameDoesntMatchRegex() {
		TestSuite oneTestSuite = new TestSuite1();
		TestComponent anotherSuiteTest = new TestSuite2();
		oneTestSuite.setRegex("(.*)TestSuite1(.*)");
		oneTestSuite.addTestComponent(anotherSuiteTest);
		oneTestSuite.start();
		Assert.assertFalse(anotherSuiteTest.isExecuted());
	}
	
	@Test
	public void getSuperSuiteNameForNotNestedTestSuitesIsEmpty() {
		TestSuite oneTestSuite = new TestSuite1();
		Assert.assertTrue(oneTestSuite.getSuperSuiteName().isEmpty());
	}
	
	@Test
	public void getSuperSuiteNameForNestedTestSuitesIsntEmpty() {
		TestSuite oneTestSuite = new TestSuite1();
		TestSuite anotherSuiteTest = new TestSuite2();
		oneTestSuite.addTestComponent(anotherSuiteTest);
		Assert.assertFalse(anotherSuiteTest.getSuperSuiteName().isEmpty());
	}
	
	@Test
	public void getSuperSuiteNameForNestedTestSuitesReturnsParentClassName() {
		TestSuite oneTestSuite = new TestSuite1();
		TestSuite anotherSuiteTest = new TestSuite2();
		oneTestSuite.addTestComponent(anotherSuiteTest);
		Assert.assertEquals(anotherSuiteTest.getSuperSuiteName(), "TestSuite1");
	}
	
	@Test
	public void skippingOneTestProducesCountSkipBigger() {
		TestSuite oneTestSuite = new TestSuite1();
		oneTestSuite.start();
		int countTestsSkipped = oneTestSuite.countSkipped();
		
		TestSuite anotherSuiteTest = new TestSuite1();
		String existingTestNameInTestSuite1 = "exampleFailTest";
		anotherSuiteTest.skipTest(existingTestNameInTestSuite1);
		anotherSuiteTest.start();
		int countTestsSkippedAfterSkip = anotherSuiteTest.countSkipped();
		
		Assert.assertTrue(countTestsSkipped < countTestsSkippedAfterSkip);
	}
	
	@Test
	public void inlineSkippedTestThrowsExceptionWhenIsVerified() {
		String existingInlineSkippedTest = "exampleInlineSkippedTest";
		exception.expect(CannotVerifyNonExecutedTestException.class);
		test1.verifyTest(existingInlineSkippedTest);
	}
	
	
//	@Test
//	public void testSuiteisAncestorXMLforAddedTestCase() {
//		TestSuite oneTestSuite = new TestSuite1();
//		String anyTestName = "anyTestName";
//		TestCase example = new TestCase(anyTestName);
//		Assertion assertion = new Assertion();
//		assertion.assertTrue(true);
//		example.getAssertions().add(assertion);
//		oneTestSuite.addTestComponent(example);
//		oneTestSuite.start();
//		System.out.println(example.toXMLElement().getParent());
//		System.out.println(oneTestSuite.toXMLElement());
//		
//		Assert.assertTrue(oneTestSuite.toXMLElement().isAncestor(example.toXMLElement()));
//	}
	
}
