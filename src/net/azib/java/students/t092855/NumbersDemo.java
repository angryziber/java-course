package net.azib.java.students.t092855;

public class NumbersDemo {
    public static void main(String[] args) {

	    Fibonacci fibonacci = new Fibonacci();
	    System.out.println("100th number in the Fibonacci sequence is " + fibonacci.getNumber(100));

	    Factorial factorial = new Factorial();
	    System.out.println("Factorial of 100 is " + factorial.getNumber(100));

    }
}
