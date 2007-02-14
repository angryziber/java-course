package net.azib.java.students.t050209;

/**
 * AssertionTest
 *
 * @author t050209
 */
public class AssertionTest {
		
	public static void doSomething(Object ... ints) {
		// old version
		/*for (int i = 0; i < ints.length; i++) {
			int value = ints[i];
			System.out.println(value);
		}*/
		// new version
		for (Object value : ints)
			System.out.println(value + " " + value.getClass().toString());
		
	}
	
	public static void main(String ... args) {
		// TODO Auto-generated method stub
		assert args.length == 1 : "Not enough command-line parameters given";
		System.out.println("Parameter " + args[0]);
		System.out.printf("%s %s", args[0], "world!\n");
	
		doSomething(110, 25L, 36, "String");
	
	/* main("a", "b"); vs. main(new String[] {"a", "b"}); */
	
	}
}
