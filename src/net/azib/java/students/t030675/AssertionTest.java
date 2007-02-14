package net.azib.java.students.t030675;

/**
 * AssertionTest
 *
 * @author t030675
 */
public class AssertionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*assert args.length >= 1 : "Not enough command-line parameters given";
		System.out.println("Parameter: " + args[0]);
		*/
		//System.out.printf("%d %d",1,2);
		doSomething(5, "hello", 1L, "bla");
	}
	
	public static void doSomething(Object ... ints){
		assert ints.length >= 1;
		for (Object i : ints) {
			System.out.println(i.getClass().toString());
		}
	}

}
