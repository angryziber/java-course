/**
 * @author Stanislav
 * 
 */
public class NumbersDemo {
	public static void main(String[] args) {
		MyFactorial factorial = new MyFactorial();
		MyFibonacci fibonacci = new MyFibonacci();
		System.out.print("The Factorial sequence 100th number is: ");
		factorial.count();
		System.out.print("The Fibonacci sequence 100th number is: ");
		fibonacci.count();
	}

}
