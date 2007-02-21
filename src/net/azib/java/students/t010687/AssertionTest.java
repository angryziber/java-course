package net.azib.java.students.t010687;

/**
 * AssertionTest
 *
 * @author t010687
 */
public class AssertionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		assert args.length ==1: "Not enough command-line parameters given";
		
		System.out.println("Parameter: " + args[0]);
	}

}
