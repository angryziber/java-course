package net.azib.java.students.t104922;

/**
 * Created by IntelliJ IDEA.
 * User: PS1c0m
 * Date: 3.02.11
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
    public static void main(String[] args) {
        int x = 5;
        for (int i = 0; i < x; i++) {
            printHello(i);
        }
    }

    public static void printHello(int y) {
        System.out.println("Hello World!");
        System.out.println(y);
    }
}
