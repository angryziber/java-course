/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321;

/**
 *
 * @author Karl
 */
public class Booleans {

    static boolean a(){
        System.out.println("a");
        return true;}
    static boolean b(){
        System.out.println("b");
        return false;}

    public static void main(String... args) {
        System.out.println(a() || b());
        System.out.println(1==2 ? "true" : false);
    }
}
