package net.azib.java.students.t030636.second;

/**
 * AssertionTest
 *
 * @author t030636
 */
public class AssertionTest {

	public static void doSomething(int ... ints) {
		assert ints.length >=1;
		//int[] ints;
		//for (int i; i < ints.length; i++){
		for (int value : ints){
			//int value = ints[i]; välja kommitud read teevad sama mis muud
			
			System.out.println(value);
		}
	}
	
	public static void main(String ... args) {
		assert args.length == 1 : "Not enought parameters given";
		System.out.println("Parameter: " + args[0]);
		int i= 127498749;
		System.out.printf("%d %d \n", i, 10);
		
		//main("a", "b");
		//main(new String[] {"a", "b"});
		doSomething(10, 60, 74, 90);
		
	}
}
