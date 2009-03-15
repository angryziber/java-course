/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture4;

/**
 * compiled into two files: OuterClass.class and OuterCalss$InnerClass.class
 * @author Karl
 */
public class OuterClass {

    private static final String CONSTANT = "STATIC CONSTANT";
    private String outerField = "OUTER";
    InnerClass inner = new InnerClass();

    public class InnerClass {

        public void doSomething() {
            System.out.println(outerField);
        }
    }

    public static class StaticInnerClass {

        public void doSomething() {
            System.out.println(CONSTANT);
        }
    }

    public static void main(String... args) {
        OuterClass o = new OuterClass();
        o.inner.doSomething();
        StaticInnerClass sic = new StaticInnerClass();
        sic.doSomething();

    }
}
