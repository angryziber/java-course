/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321;

import java.math.BigInteger;

/**
 *
 * @author Karl
 */
public class Numbers {

    public static void main(String... args) {
        double f = 1.0;
        f -= 0.1;
        System.out.println(f);

        if (f >= 0.1) {
            System.out.println("Can buy!");
        }

        System.out.println(Integer.MAX_VALUE);

        BigInteger i = new BigInteger("12341567894561234564894765613215648976354");
        i = i.add(BigInteger.ONE);
        System.out.println(i);


    }
}
