package net.azib.java.students.t072054.hometask1;

/**
 * Fibonacci
 * 
 * @author Roman
 */
public class Fibonacci {
	public long calculateFib(int fibo_num) {
		long fibo_answer = 1;
		long fibo_old = 1;
		long temp;

		for (int i = 0; i < fibo_num - 1; i++) {
			temp = fibo_answer;
			fibo_answer += fibo_old;
			fibo_old = temp;
		}

		System.out.println("The answer is: " + fibo_answer);
		
		return fibo_answer;
	}
}
