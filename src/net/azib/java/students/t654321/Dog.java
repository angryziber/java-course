/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321;

/**
 *
 * @author Karl
 */
public class Dog {
    private String name;
    private byte age;

    public Dog(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Dog name is " + name + " and age is " + age ;
    }
}
