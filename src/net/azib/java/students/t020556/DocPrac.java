package net.azib.java.students.t020556;

import java.math.BigInteger;

/**
 * For <i>documentation</i> practice
 *
 * @version 1.0
 * @author t020556
 */
public class DocPrac {
	
	/**
	 * Prints out some stuff for the user
	 * @param name specify name to display
	 */
	private static void showFib(int fibNr){
		fibNr--;
		BigInteger big1 = new BigInteger("0");
		BigInteger big2 = new BigInteger("1");
		
		while(fibNr-- > 0){
			BigInteger bigAbi = big1.add(big2);
			big1 = big2;
			big2 = bigAbi;
		}
		System.out.println(big2);
	}
	
	/**
	 * Main entry popint
	 * @param args input parameters for the main method
	 * @see currently parameter count can be only 1
	 */
	public static void main(String ... args){
		assert args.length == 1 : "Wrong number of arguments, dude!";
		System.out.printf("Printing fibonacci nr for %s iterations\n", args[0]);
		Integer intIncoming = new Integer(args[0]);
		showFib(intIncoming);
		
		Dog doggy = new Dog("Pitsu", (byte)1);
		System.out.println(doggy.getName());
		
				
	}

}
