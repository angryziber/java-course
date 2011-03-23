package net.azib.java.students.t092861;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTestsRunner {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTestsRunner.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(FactorialTest.class);
		suite.addTestSuite(FibonacciTest.class);
		//$JUnit-END$
		return suite;
	}

}
