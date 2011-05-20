package net.azib.java.students.t103784.homework;



import static org.junit.Assert.*;

/**
 * @author      Ott Madis Ozolit <karuott321@hotmail.com>
 * @version     1.6
 * @since       2011.0520
 *
 */
public class MainTest extends Main {

	/**
	 * Tests the main method with console arguments.
	 *
	 * Checks if the main method can properly handle and
	 * assign the arguments entered by the user.
	 */
	@org.junit.Test
	public void testMain () {

		String[] args = {"-console","-console"};
		setParameters(args);
		assertArrayEquals("Failed input parameter", args[0].getBytes(), inputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args[1].getBytes(), outputMethod.getBytes());
		inputMethod = null;
		inputParameter = null;
		outputMethod = null;
		outputParameter = null;

		String[] args2 = {"-db", "-csv"};
		setParameters(args2);
		assertArrayEquals("Failed input parameter", args2[0].getBytes(), inputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args2[1].getBytes(), outputMethod.getBytes());
		inputMethod = null;
		inputParameter = null;
		outputMethod = null;
		outputParameter = null;

		String[] args3 = {"-csv", "sample.csv", "-html"};
		setParameters(args3);
		assertArrayEquals("Failed input parameter", args3[0].getBytes(), inputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args3[1].getBytes(), inputParameter.getBytes());
		assertArrayEquals("Failed input parameter", args3[2].getBytes(), outputMethod.getBytes());
		inputMethod = null;
		inputParameter = null;
		outputMethod = null;
		outputParameter = null;

		String[] args4 = {"-csv", "-xml", "sample.xml"};
		setParameters(args4);
		assertArrayEquals("Failed input parameter", args4[0].getBytes(), inputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args4[1].getBytes(), outputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args4[2].getBytes(), outputParameter.getBytes());
		inputMethod = null;
		inputParameter = null;
		outputMethod = null;
		outputParameter = null;

		String[] args5 = {"-db", "1", "-html", "sample.html"};
		setParameters(args5);
		assertArrayEquals("Failed input parameter", args5[0].getBytes(), inputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args5[1].getBytes(), inputParameter.getBytes());
		assertArrayEquals("Failed input parameter", args5[2].getBytes(), outputMethod.getBytes());
		assertArrayEquals("Failed input parameter", args5[3].getBytes(), outputParameter.getBytes());
	}

}
