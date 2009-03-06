/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture2;

/**
 *
 * @author Karl
 */
public class Turtle extends Animal {

    String food;

    public Turtle(String name, int age, String food) {
        super(name, age);
        this.food = food;
    }

    @Override
    String makeNoise() {
        return null;
    }

    @Override
    public String toString() {
        return "I'm turtle named " + this.name + " and I'm " + this.age + " years old. I eat " + this.food;
    }
}
