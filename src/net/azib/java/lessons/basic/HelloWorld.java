package net.azib.java.lessons.basic;

import java.util.Date;

public class HelloWorld {
    public static void main(String[] args) {
        printHello();
        printHello();
        printHello();

        Date date = new Date();
        System.out.println(date.toString());
    }

    private static void printHello() {
        System.out.println("Hello World!");
    }
}
