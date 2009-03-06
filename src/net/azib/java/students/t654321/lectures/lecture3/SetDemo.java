/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.lectures.lecture3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Karl
 */
public class SetDemo {
    public static void main(String... args) {
        Set s1 = new HashSet();
        Set s2 = new TreeSet();
        Set s3 = new LinkedHashSet();

        fill(s1);
        fill(s2);
        fill(s3);

    }

    static void fill(Set s){
        s.add("d");
        s.add("e");
        s.add("f");
        s.add("e");
        s.add("e");
        s.add("d");
        s.add("o");
        s.add("l");
        System.out.println("size = " + s.size());
        System.out.println(s);
    }
}
