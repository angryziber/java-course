package net.azib.java.students.t030630;

/**
 * AssertionTest
 *
 * @author Kasutaja
 */
public class AssertionTest {

	/** uses varargs
	 * @param args
	 */
	private static void process(int ... a){ // ...(kolm punkti) - sama kui massiiv
		for(int i: a){
			System.out.printf("%d\n", i);
		}
	}
	
	public static void doSomething(Object ... ints){
		assert ints.length >=1 : "Empty array"; 
		for(Object value : ints) 
		// means, for each value from ints(e.g. value = ints[i])
			System.out.println(value + " " + value.getClass().toString());
			
			
	}
	
	public static void main(String ... args) { // only one args parameter, must be last in list of parameeters
		assert args.length == 1 : "Not enough command line parameters";
		//VM arguments "-ea"
		System.out.println("Parameter:  " + args[0]);
		
		process(1,2,3,4,5);
//		main("a", "b");
//		main(new String[]{"a", "b"});
		
		doSomething(5, "hi", 10, 4f, 5d);
	}

}
