/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;

/**
 *
 * @author Karl
 */
public class ExceptionDemo {

    public static void main(String... args) {

        try {

            String[] s = {"a"};
           // System.out.println(s[10]);

            Collection c = new ArrayList();
            c.add("A");
            for (Object object : c) {
                c.add("c");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Arrsy not big enought");
        }
        catch (ConcurrentModificationException e){
//            System.err.println("Concurrrent exception");
            throw new UnsupportedOperationException(e);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        catch (Error e){
            System.err.println("Something really bad happened");
        }
        finally {
            System.out.println("Finished!0");
        }

//        Animal a = null;
//        a.toString();
    }
}
