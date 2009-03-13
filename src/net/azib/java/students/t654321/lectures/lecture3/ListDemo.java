/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.lectures.lecture3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Arraylist, siis kuik indeksi järgi otsida
 * Linked list, kui vaja palju lisada ja eemaldada listist
 *@author Karl
 */
public class ListDemo {
    public static void main(String... args) {
        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new LinkedList<String>();

        fill(l1);
        fill(l2);

        l2.add("12");
        l2 = Collections.unmodifiableList(l2);
        l2.add("g");
    }

    static void fill(Collection c){
        c.add("d");
        c.add("e");
        c.add("f");
        c.add("e");
        c.add("e");
        c.add("d");
        c.add("o");
        c.add("l");
        System.out.println("size = " + c.size());
        System.out.println(c);
    }
}
