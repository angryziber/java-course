package net.azib.java.students.t030633.lessons;

/**
 * AssertionDemo
 * 
 * @author t030633
 */
public class AssertionDemo {
	public static void main(String[] args) {
		int i = 3;
		assert i == 5 : "the world has collapsed"; 
		// if not then program ends if assertions are 'on'
		// -ea
		System.out.println(i);
	}
}
