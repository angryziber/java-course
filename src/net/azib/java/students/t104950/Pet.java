package net.azib.java.students.t104950;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 25.02.11
 * Time: 9:25
 * To change this template use File | Settings | File Templates.
 */
abstract class Pet extends Animal {
        public Pet(int age, String name){
        super(age);
        this.name=name;
    }
     private String name;
     String getName(){return name;};
    abstract void makeSound();
}
