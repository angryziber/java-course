package net.azib.java.simple;

/**
 * AssertionTest
 *
 * @author anton
 */
public class AssertionTest {
	
	public static void doSomething(Object ... ints) {
		//assert ints.length >= 1;
		for (Object value : ints) {
			System.out.println(value + " " + value.getClass().toString());
		}
	}
	
	public static void main(String[] args) {
		assert args.length >= 1 && args.length <= 3 : 
			"Not enough command-line parameters given";
		
		System.out.println("Parameter: " + args[0]);
		
		doSomething();
		doSomething(10, "hello", 11L, 90, 67);
	}
}
