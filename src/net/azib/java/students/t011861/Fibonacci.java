package net.azib.java.students.t011861;
/**
 * Fibonacci
 *
 * @author 011861
 */
public class Fibonacci {
	/**
	 * @param args
	 */
	public static Double calcFibonacci (int counter) {
		Double a = new Double(0);
		Double b = new Double(1);
		Double c = new Double(0);
		int i = 0;
		if (counter == 0) 
			c = a;
		else if (counter == 1) 
			c = b;
		else
			while (i < counter - 1){
				c = a + b;
				a = b;
				b = c;
				i++;
			}
		return c; 
	}
public static void main(String[] args) {
	int setMember = 10;
	System.out.print(setMember);
	System.out.print(calcFibonacci(setMember));
}
}