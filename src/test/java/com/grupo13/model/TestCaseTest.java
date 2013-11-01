package com.grupo13.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCaseTest {

	private TestSuite test;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		// creo una clase anonima para testear TestCase que es abstracta
		test = new TestSuite() {
			
			public void exampleFailTest() {
				fail();
			}
			
			public void exampleAssertTrueTest() {
				assertTrue(true);
			}
			
			public void exampleAssertTrueTestFail() {
				assertTrue(false);
			}
			
			public void exampleAssertFalseTest() {
				assertFalse(false);
			}
			
			public void exampleAssertFalseTestFail() {
				assertFalse(true);
			}
			
			public void assertTruePassingAndFailTest() {
				assertTrue(true);
				fail();
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldPass() {
				assertEquals("Hola","Hola");
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldntPass() {
				assertEquals("Hola","Chau");
			}
			
			public void assertEqualsShouldntPassIfReceiveNullObjectAs1stParam() {
				String objectString = null;
				assertEquals(objectString,"Chau");
			}
			
			public void assertEqualsShouldntPassIfReceiveNullObjectAs2ndParam() {
				String objectString = null;
				assertEquals("Hello",objectString);
			}
			
			public void assertEqualsShouldntPassIfReceiveBothNullObjects() {
				String objectString = null;
				assertEquals(objectString,objectString);
			}
			
			public void exampleAssertIsNullTestThatShouldPass() {
				String objectString = null;
				assertIsNull(objectString);
			}
			
			public void exampleAssertIsNullTestThatShouldntPass() {
				String objectString = new String("Hello world");
				assertIsNull(objectString);
			}
			
			public void exampleAssertIsNotNullTestThatShouldPass() {
				String objectString = new String("Hello world");
				assertIsNotNull(objectString);
			}
			
			public void exampleAssertIsNotNullTestThatShouldntPass() {
				String objectString = null;
				assertIsNotNull(objectString);
			}
			
			public void exampleAssertEqualsIntTestThatShouldPass() {
				int a = 45;
				assertEquals(a, a);
			}
			
			public void exampleAssertEqualsIntTestThatShouldntPass() {
				int a = 23;
				int b = 1988;
				assertEquals(a, b);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldPass() {
				float a = (float) 23.7;
				assertEquals(a, a);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldntPass() {
				float a = (float) 23.7;
				float b = (float) 23.6;
				assertEquals(a, b);
			}

			public void run() {
				//booleans
				exampleAssertTrueTest();
				exampleAssertTrueTestFail();
				exampleAssertFalseTest();
				exampleAssertFalseTestFail();
				
				//objects
				exampleAssertEqualsObjectsTestThatShouldPass();
				exampleAssertEqualsObjectsTestThatShouldntPass();
				exampleAssertIsNullTestThatShouldPass();
				exampleAssertIsNullTestThatShouldntPass();
				exampleAssertIsNotNullTestThatShouldPass();
				exampleAssertIsNotNullTestThatShouldntPass();
				assertEqualsShouldntPassIfReceiveNullObjectAs1stParam();
				assertEqualsShouldntPassIfReceiveNullObjectAs2ndParam();
				assertEqualsShouldntPassIfReceiveBothNullObjects();
				
				
				//floats
				exampleAssertEqualsFloatTestThatShouldPass();
				exampleAssertEqualsFloatTestThatShouldntPass();
				//integers
				exampleAssertEqualsIntTestThatShouldntPass();
				exampleAssertEqualsIntTestThatShouldPass();
				
				//fail
				exampleFailTest();
				
				//combined tests
				assertTruePassingAndFailTest();
				
			}

		};
		test.start();
	}

	@Test
	public void existingTestIsPassingIfItsAssertTrueDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertTrueTest"));
	}
	
	@Test
	public void existingTestIsntPassingIfItsAssertTrueFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertTrueTestFail"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertFalseDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertFalseTest"));
	}
	

	@Test
	public void existingTestIsntPassingIfItsAssertFalseFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertFalseTestFail"));
	}

	@Test
	public void existingTestIsPassingIfItsAssertEqualObjectDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldPass"));
	}
	
	@Test
	public void existingTestIsntPassingIfItsAssertEqualObjectFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldntPass"));
	}
	
	@Test
	public void testIsntPassingIfItsAssertNullFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertIsNullTestThatShouldntPass"));
	}
	
	@Test
	public void testIsPassingIfItsAssertNullPass() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertIsNullTestThatShouldPass"));
	}

	@Test
	public void testIsntPassingIfItsAssertNotNullFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertIsNotNullTestThatShouldntPass"));
	}
	
	@Test
	public void testIsPassingIfItsAssertNotNullPass() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertIsNotNullTestThatShouldPass"));
	}
	
	@Test
	public void testIsPassingIfItsAssertEqualIntDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsIntTestThatShouldPass"));
	}

	@Test
	public void existingTestIsntPassingIfItsAssertEqualIntFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertEqualsIntTestThatShouldntPass"));
	}
	
	@Test
	public void existingTestIsPassingIfItsAssertEqualFloatDontFail() {
		
		Assert.assertTrue(test.verifyTest("exampleAssertEqualsFloatTestThatShouldPass"));
	}
	
	@Test
	public void existingTestIsntPassingIfItsAssertEqualFloatFail() {
		
		Assert.assertFalse(test.verifyTest("exampleAssertEqualsFloatTestThatShouldntPass"));
	}
	
	@Test
	public void testIsntPassingIfItsAssertEqualReceiveNullObjectAs1stParam() {
		
		Assert.assertFalse(test.verifyTest("assertEqualsShouldntPassIfReceiveNullObjectAs1stParam"));
	}
	
	@Test
	public void testIsntPassingIfItsAssertEqualReceiveNullObjectAs2stParam() {
		
		Assert.assertFalse(test.verifyTest("assertEqualsShouldntPassIfReceiveNullObjectAs2ndParam"));
	}
	
	@Test
	public void testIsntPassingIfItsAssertEqualReceiveBothNullObjects() {
		
		Assert.assertFalse(test.verifyTest("assertEqualsShouldntPassIfReceiveBothNullObjects"));
	}
	
	@Test
	public void verifyTestThatExecuteFailReturnsFalse() {
		
		Assert.assertFalse(test.verifyTest("exampleFailTest"));
	}
	
	@Test
	public void twoAssertsInTestsAssertTruePassingAndFailShoudntPass() {
		
		Assert.assertFalse(test.verifyTest("assertTruePassingAndFailTest"));
	}
	
	@Test
	public void verifyTestThrowsIllegalStateExceptionWhenTestDoesntExists() {
		exception.expect(IllegalStateException.class);
		test.verifyTest("nonExistingTest");
	}
}
