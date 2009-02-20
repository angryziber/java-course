package net.azib.java.students.t074918;

/**
 * Loops
 *
 * @author Mart Mangus
 */
public class Loops {
	
	public static void main(String[] args) {
		//String[] s = {'a', 'b', 'c'};
		
		outer: while(true) {
			inner: while(true) {
				break outer;
			}
		}
		System.out.println("Saab lõputust tsüklist välja küll...");
		
		
		
	}

}
