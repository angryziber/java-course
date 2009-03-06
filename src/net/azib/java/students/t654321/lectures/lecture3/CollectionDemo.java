/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.lectures.lecture3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Karl
 */
public class CollectionDemo {
    public static void main(String... args) {
    List l = Arrays.asList("a", "b", "c");
    l.get(0);
    System.out.println(l.contains("d"));

    Iterator i = l.iterator();
    while (i.hasNext()) {
            System.out.println(i.next());
    }

    
    }
}
