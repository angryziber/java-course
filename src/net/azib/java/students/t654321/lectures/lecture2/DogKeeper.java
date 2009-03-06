/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture2;

import net.azib.java.students.t654321.lectures.lecture1.Dog;

/**
 *
 * @author Karl
 */
public class DogKeeper {

    public static void main(String... args) {

        Dog d1 = new Dog("Pontu", (byte) 1);
        Dog d2 = new Dog("Pontu", (byte) 2);

        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
    }
}
