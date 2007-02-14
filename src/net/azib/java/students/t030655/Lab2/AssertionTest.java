package net.azib.java.students.t030655.Lab2;

/**
 * AssertionTest
 *
 * @author t030655
 */
public class AssertionTest {

	public static void doSomething(Object ... ints){
		assert ints.length >= 1;
		for (Object value : ints){
			System.out.println(value);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		assert args.length >= 1 && args.length<=3 :
			"Not enough command-line parameters given";
		
		System.out.println("Parameter: " + args[0]);
		
		doSomething(10, "hello", 11, 90, 67);
		
	}

}
