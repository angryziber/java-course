package net.azib.java.students.t104922.Lesson3;

/**
 * Created by IntelliJ IDEA.
 * User: PS1c0m
 * Date: 2.03.11
 * Time: 13:02
 * To change this template use File | Settings | File Templates.
 */
public abstract class Animal {
    private int age;
    private int weight;

    public int getAge(){
        return age;
    }
    public int getWeight(){
        return weight;
    }

    abstract void makeSound();

}
