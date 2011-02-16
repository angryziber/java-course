package net.azib.java.students.t105870.Lecture2;

public class NumbersDemo {
    static int thNumber = 100;

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(thNumber + "th Number in factorial is " + fact.launch(thNumber));

        Fibonacci fibo = new Fibonacci();
        System.out.println(thNumber + "th Number in fibonacci is " + fibo.launch(thNumber));
    }
}