/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture2;

/**
 *
 * @author Karl
 */
public class Loops {

    public static void main(String... args) {
        String[] s = {"a", "b", "c"};
        for (int i = 0; i < s.length; i++) {
            System.out.println("for loop -> " + s[i]);

        }

        for (String string : s) {
            System.out.println("for each -> " + string);
        }
    }
}
