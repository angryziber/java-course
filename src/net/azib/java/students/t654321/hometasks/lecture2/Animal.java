/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.hometasks.lecture2;

import net.azib.java.lessons.basic.Todo;
/**
 *
 * @author Karl
 */
@Todo("Implement toString() and hashCode(). Add following methods to into subclasses toString() methods.")
public abstract class Animal implements Comparable<Animal> {
    String name;
    int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    abstract String makeNoise();
    
    String waveTail() {
        return "I'm waving my " + getClass().getSimpleName().toLowerCase() + "'s tail";
    };

    public int compareTo(Animal a){
        return a.age - this.age;
    }
}
