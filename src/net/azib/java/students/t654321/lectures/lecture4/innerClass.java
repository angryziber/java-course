/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture4;

/**
 *
 * @author Karl
 */
public class innerClass {

    public static void main(String... args) {
        OuterClass o = new OuterClass();
        o.inner.doSomething();

        OuterClass.StaticInnerClass si = new OuterClass.StaticInnerClass();
        si.doSomething();


    }
}
