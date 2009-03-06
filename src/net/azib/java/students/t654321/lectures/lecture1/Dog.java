/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture1;

/**
 *
 * @author Karl
 */
public class Dog {

    String name;
    private byte age;

    public Dog(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog name is " + name + " and age is " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            return ((Dog) o).name.equals(this.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }
}
