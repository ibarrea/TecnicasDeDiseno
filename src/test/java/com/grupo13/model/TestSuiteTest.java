package com.grupo13.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

		public void assertEqualsShouldntPassIfReceiveNullObjectAs1stParam() {
			String objectString = null;
			assertEquals(objectString, "Chau");
		}

		public void assertEqualsShouldntPassIfReceiveNullObjectAs2ndParam() {
			String objectString = null;
			assertEquals("Hello", objectString);
		}

		public void assertEqualsShouldntPassIfReceiveBothNullObjects() {
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
			assertEqualsShouldntPassIfReceiveNullObjectAs1stParam();
			assertEqualsShouldntPassIfReceiveNullObjectAs2ndParam();
			assertEqualsShouldntPassIfReceiveBothNullObjects();

			// floats
			assertEqualsFloatTestThatShouldPass();
			assertEqualsFloatTestThatShouldntPass();
			// integers
			assertEqualsIntTestThatShouldntPass();
			assertEqualsIntTestThatShouldPass();

			// fail
			exampleFailTest();

			// combined tests
			assertTruePassingAndFailTest();

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
		TestSuite test2 = new TestSuite2();
		test1.addTestComponent(test2);
		test1.start();
		test1.showTest();
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
	public void existingTestIsntPassingIfItsAssertEqualFloatFail() {

		Assert.assertFalse(test1.verifyTest("assertEqualsFloatTestThatShouldntPass"));
	}

	@Test
	public void testIsntPassingIfItsAssertEqualReceiveNullObjectAs1stParam() {

		Assert.assertFalse(test1.verifyTest("assertEqualsShouldntPassIfReceiveNullObjectAs1stParam"));
	}

	@Test
	public void testIsntPassingIfItsAssertEqualReceiveNullObjectAs2stParam() {

		Assert.assertFalse(test1.verifyTest("assertEqualsShouldntPassIfReceiveNullObjectAs2ndParam"));
	}

	@Test
	public void testIsntPassingIfItsAssertEqualReceiveBothNullObjects() {

		Assert.assertFalse(test1.verifyTest("assertEqualsShouldntPassIfReceiveBothNullObjects"));
	}

	@Test
	public void verifyTestThatExecuteFailReturnsFalse() {

		Assert.assertFalse(test1.verifyTest("exampleFailTest"));
	}

	@Test
	public void twoAssertsInTestsAssertTruePassingAndFailShoudntPass() {

		Assert.assertFalse(test1.verifyTest("assertTruePassingAndFailTest"));
	}

	@Test
	public void verifyTestThrowsIllegalStateExceptionWhenTestDoesntExists() {
		exception.expect(IllegalStateException.class);
		test1.verifyTest("nonExistingTest");
	}
}
