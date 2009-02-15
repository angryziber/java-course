/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.lectures.lecture1;

import java.util.Date;

/**
 *
 * @author Karl
 */
public class HelloWorld {

    public static void main(String... args) {
        System.out.println (Constants.GREETING_MESSAGE);
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        Dog dog = new Dog("Pluto",(byte)3);
        System.out.println(dog);
    }

}
