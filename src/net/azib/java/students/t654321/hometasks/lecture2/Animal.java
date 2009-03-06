/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.hometasks.lecture2;

/**
 *
 * @author Karl
 */
public abstract class Animal {
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
}
