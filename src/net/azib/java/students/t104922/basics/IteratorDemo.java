package net.azib.java.students.t104922.basics;

import org.hsqldb.lib.Iterator;

import java.util.*;

public class IteratorDemo{
    public static void main(String[] args) {

        Set set = new HashSet();
        List list = new ArrayList();
        demo(set);
        demo(list);
    }

    private static void demo(Collection c) {
        System.out.println(c.getClass().getSimpleName());
        c.add("A");
        c.add("B");
        c.add("C");

        java.util.Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
