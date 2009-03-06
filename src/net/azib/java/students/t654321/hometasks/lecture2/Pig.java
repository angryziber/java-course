/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture2;

/**
 *
 * @author Karl
 */
public class Pig extends Animal {

    String color = "pink";

    public Pig(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    String makeNoise() {
        return "Oink-Oink";
    }

    @Override
    public String toString() {
        return "I'm pig named " + this.name + " and I'm " + this.age + " years old. I'm " + this.color;
    }
}
