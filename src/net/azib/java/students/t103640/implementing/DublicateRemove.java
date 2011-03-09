package net.azib.java.students.t103640.implementing;

import net.azib.java.lessons.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.TreeSet;

public class DublicateRemove implements DuplicateRemover {


    public static void main(String[] args) {
         String[] jada = {"Nescafe","Dynamit","Hustler","Hustler","Lx power","Red Bull","Lx power"};

    System.out.println("Jada: " + Arrays.toString(jada));

    DublicateRemove eemaldus = new DublicateRemove();
        System.out.println("Tulemus: " + Arrays.toString(eemaldus.removeDuplicateStrings(jada)));

    }
     public DublicateRemove(){}


    public String[] removeDuplicateStrings(String... array) {
        TreeSet<String> kogu = new TreeSet<String>(Arrays.asList(array));
        String[] tulem = new String[kogu.size()];
        kogu.toArray(tulem);
        return tulem;
    }
}

