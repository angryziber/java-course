/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.azib.java.students.t654321.hometasks.lecture2;

/**
 *
 * @author Karl
 */
public class AnimalKeeper {
    public static void main(String... args) {
    Animal[] animalkeeper = {new Turtle("Elvis", 100, "grass"),new Pig("Pinky", 3, "pink"),new Turtle("Mary", 101, "green grass"),new Donkey("Iiah", 6, 100f, 1.07f)};

        for (Animal animal : animalkeeper) {
            System.out.println(animal.toString());
            System.out.println(animal.makeNoise());
            System.out.println(animal.waveTail());
            System.out.println("");
        }
    }
}
