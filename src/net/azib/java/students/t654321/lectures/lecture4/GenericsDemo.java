package net.azib.java.students.t654321.lectures.lecture4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * <E(Element)>
 * Map<K(Key),V(value)>
 * <T(Type)>
 * <S(Parameter)>
 * Generics can be of massives(Massives are objects)
 * @author Karl
 */
public class GenericsDemo {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("c", "d", "e");
        Collections.sort(l);

        Collection<String> c = l;

        for (String object : c) {
        }

        Map<Object,Object> m = new Properties();
        m.put("a", "c");
        m.get("a");

//        List<Object> lo;
//        List<String> ls;
//        lo = ls;

    }
}
