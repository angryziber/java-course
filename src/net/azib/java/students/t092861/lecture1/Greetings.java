package net.azib.java.students.t092861.lecture1;

/**
 * @author Stanislav / 092861
 *
 */
public class Greetings {

	private void printHello(String s) {
		System.out.println(s);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		Greetings greetings = new Greetings();
		greetings.printHello("Hello world 2!");
		greetings.printHello("Hello world 3!");
	}
}
