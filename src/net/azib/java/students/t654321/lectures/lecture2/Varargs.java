/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.lectures.lecture2;

/**
 *
 * @author Karl
 */
public class Varargs {

    public static void printAll(Object ... params) {
        for (Object string : params) {
            System.out.println(string);
        }
    }

    public static void main(String... args) {
        printAll("a","b","c");
        printAll(1,2,3);
    }

}
