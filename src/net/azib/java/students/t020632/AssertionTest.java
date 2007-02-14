package net.azib.java.students.t020632;

/**
 * AssertionTest
 *
 * @author t020632
 */
public class AssertionTest {
	
	public static void doSomething(int ... ints){
		for(int value : ints){
			System.out.println(value);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		
		assert args.length == 1 : "Not enough command - line parameters given";
		System.out.println("parameter: "+ args[0]);
		
		System.out.printf("%d \n", i);
		doSomething(1);
	}

}
