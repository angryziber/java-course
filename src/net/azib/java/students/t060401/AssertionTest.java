package net.azib.java.students.t060401;

/**
 * AssertionTest
 * 
 * @author t060401
 */
public class AssertionTest {

	private static void doSomething(int ... ints) {
		assert ints.length >= 0 : "Array is empty";
		for (int value : ints) {
			System.out.println(value);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String ... args) {
		assert args.length == 1 : "Not enough command line parameters";
		System.out.println("Parameter: "+args[0]);
		
		int i = 1;
		System.out.printf("int = %d\n", i);
		
		doSomething(1,2,3);
		
	}

}
