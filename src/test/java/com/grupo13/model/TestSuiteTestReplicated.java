package com.grupo13.model;

/*
 * Clase TestSuiteTestReplicated: son los tests de nuestro c�digo realizados con
 * nuestro framework.
 */

public class TestSuiteTestReplicated extends TestSuite {

	private TestSuite test;

	public void setup() {
		// creo una clase anonima para testear TestCase que es abstracta
		test = new TestSuite() {
			
			public void exampleFailTest() {
				fail();
			}
			
			public void exampleAssertTrueTest() {
				assertTrue(true);
			}
			
			public void exampleAssertFalseTest() {
				assertFalse(false);
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldPass() {
				assertEquals("Hola", "Hola");
			}
			
			public void exampleAssertEqualsObjectsTestThatShouldntPass() {
				assertEquals("Hola", "Chau");
			}
			
			public void exampleAssertEqualsIntTestThatShouldPass() {
				assertEquals(45, 45);
			}
			
			public void exampleAssertEqualsIntTestThatShouldntPass() {
				assertEquals(23, 1988);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldPass() {
				assertEquals(23.7, 23.7);
			}
			
			public void exampleAssertEqualsFloatTestThatShouldntPass() {
				assertEquals(23.7, 23.6);
			}

			public void run() {
				//booleans
				exampleAssertTrueTest();
				exampleAssertFalseTest();
				
				//objects
				exampleAssertEqualsObjectsTestThatShouldPass();
				exampleAssertEqualsObjectsTestThatShouldntPass();
				
				
				//floats
				exampleAssertEqualsFloatTestThatShouldPass();
				exampleAssertEqualsFloatTestThatShouldntPass();
				//integers
				exampleAssertEqualsIntTestThatShouldntPass();
				exampleAssertEqualsIntTestThatShouldPass();
				
				//fail
				exampleFailTest();
				
			}

		};
		test.start();

	}

	public void existingTestIsPassingIfItsAssertTrueDontFail() {
		
		 assertTrue(test.verifyTest("exampleAssertTrueTest"));
	}

	public void existingTestIsPassingIfItsAssertFalseDontFail() {
		
		 assertTrue(test.verifyTest("exampleAssertFalseTest"));
	}

	public void existingTestIsPassingIfItsAssertEqualObjectDontFail() {
		
		 assertTrue(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldPass"));
	}
	
	public void existingTestIsntPassingIfItsAssertEqualObjectFail() {
		
		 assertFalse(test.verifyTest("exampleAssertEqualsObjectsTestThatShouldntPass"));
	}

	public void existingTestIsPassingIfItsAssertEqualIntDontFail() {
		
		 assertTrue(test.verifyTest("exampleAssertEqualsIntTestThatShouldPass"));
	}

	public void existingTestIsntPassingIfItsAssertEqualIntFail() {
		
		 assertFalse(test.verifyTest("exampleAssertEqualsIntTestThatShouldntPass"));
	}
	
	public void existingTestIsPassingIfItsAssertEqualFloatDontFail() {
		
		 assertTrue(test.verifyTest("exampleAssertEqualsFloatTestThatShouldPass"));
	}
	
	public void existingTestIsntPassingIfItsAssertEqualFloatFail() {
		
		assertFalse(test.verifyTest("exampleAssertEqualsFloatTesTestCaseTest.class, TestSuiteTest.classTestCaseTest.class, TestSuiteTest.classtThatShouldntPass"));
	}
	
	public void verifyTestThatExecuteFailReturnsFalse() {
		
		assertFalse(test.verifyTest("exampleFailTest"));
	}
	
	@Override
	public void run() {
		existingTestIsPassingIfItsAssertTrueDontFail();

		existingTestIsPassingIfItsAssertFalseDontFail();

		existingTestIsPassingIfItsAssertEqualObjectDontFail();
		
		existingTestIsntPassingIfItsAssertEqualObjectFail();

		existingTestIsPassingIfItsAssertEqualIntDontFail();

		existingTestIsntPassingIfItsAssertEqualIntFail();
		
		existingTestIsPassingIfItsAssertEqualFloatDontFail();
		
		existingTestIsntPassingIfItsAssertEqualFloatFail();

		verifyTestThatExecuteFailReturnsFalse();
		
	}
	
	public static void main(String[] args) {
		TestSuiteTestReplicated someTest = new TestSuiteTestReplicated();
		TestSuiteTestReplicated someTestNew = new TestSuiteTestReplicated();

		someTest.addTestComponent(someTestNew);
		someTest.start();
		someTest.showTest();
		someTest.saveTestResults();

	}
}
