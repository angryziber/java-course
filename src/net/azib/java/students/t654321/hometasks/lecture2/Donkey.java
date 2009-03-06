/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture2;

/**
 *
 * @author Karl
 */
public class Donkey extends Animal {

    float weight;
    float height;

    public Donkey(String name, int age, float weight, float height) {
        super(name, age);
        this.weight = weight;
        this.height = height;
    }

    @Override
    String makeNoise() {
        return "Hee-Haw";

    }

    @Override
    public String toString() {
        return "I'm donkey named " + this.name + " and I'm " + this.age + " years old. Strategic parameters (weight,height): " + this.weight + " , " + this.height;
    }
}
