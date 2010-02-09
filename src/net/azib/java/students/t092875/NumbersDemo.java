package net.azib.java.students.t092875;

/**
 * NumbersDemo
 *
 * @author Mihhail
 */
public class NumbersDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new NumbersDemo().start();
	}
	
	private void start(){
		NumbersGenerator[] generators = new NumbersGenerator[2];
		generators[0] = new FibonacciGenerator();
		generators[1] = new FactorialGenerator();
		for(NumbersGenerator g: generators){
			System.out.println(g.getNthNumber(100));	
		}
	}

}
