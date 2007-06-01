package net.azib.java.students.t060397.homework;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * RunTests
 *
 * @author marcus
 */
public class RunTests {
	
	  public static Test suite() {

	        TestSuite suite = new TestSuite();
	  
	        //
	        // The ShoppingCartTest we created above.
	        //
	        suite.addTestSuite(MatchTest.class);

	        //
	        // Another example test suite of tests.
	        // 
	        suite.addTest(SumAppTest.class);

	        //
	        // Add more tests here
	        //

	        return suite;
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	        junit.textui.TestRunner.run(suite());
		
	
	}
	
	  


}
