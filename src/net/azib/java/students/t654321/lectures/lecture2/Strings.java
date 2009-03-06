/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture2;

/**
 *
 * @author Karl
 */
public class Strings {

    public static void main(String... args) {
//        String s1 = "abc";
//        String s2 = new String(new char[]{'a', 'b', 'c'});
//
//        System.out.println(s1.equals(s2));
//        System.out.println(s1 == s2);
//
//        String s3 = s1 + s2 + 123;
//        System.out.println(s3);
//        String s4 = new StringBuilder().append(s1).append(s2).append(123).toString();
//        System.out.println(s4);
//        System.out.println(s3.equals(s4));

        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 1000000; i++) {
            s += i;
        }
        System.out.println("t=" + (System.currentTimeMillis() - start));

        long start1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 1000000; i++) {
            sb = sb.append(i);
        }
        System.out.println("t1=" + (System.currentTimeMillis() - start1));
    }
}
