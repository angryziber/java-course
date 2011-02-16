package net.azib.java.students.t104948;

public class NumbersDemo {
    Fibonacci firstNumber;
        Factorial secondNumber;

        public static void main(String[] args) {
            Fibonacci firstNumber = new Fibonacci();
            firstNumber.n = 100;
            Factorial secondNumber = new Factorial();
            secondNumber.n = 100;
            System.out.println(firstNumber.doFibonacci().toString());
            System.out.println(secondNumber.doFactorial().toString());
        }
}
