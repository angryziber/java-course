package net.azib.java.students.t104607;

// @author 104607 IASM

public class NumbersDemo {
    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        for (int i=0;i<20;i++) {
            System.out.print(" " + fibo.compute(i));
        }
        System.out.println("\nFibonacci[100] = " + fibo.compute(100));
        Factorial fact = new Factorial();
        for (int i=0;i<10;i++) {
            System.out.print(" " + i + "!=" + fact.compute(i));
        }
        System.out.println("\n100! = " + fact.compute(100));
    }
}
