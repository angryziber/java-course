package net.azib.java.students.t020632;

/**
 * AssertionTest
 *
 * @author t020632
 */
public class AssertionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assert args.length == 1 : "Not enough command - line parameters given";
		System.out.println("parameter: "+ args[0]);
	}

}
