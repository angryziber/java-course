package net.azib.java.students.t107678.hw2;

public class Sheep extends Animal {

    public String name, owner;

    public Sheep(String sheepName, String sheepOwner) {
        this.name = sheepName;
        this.owner = sheepOwner;

    }

    public void makeSound() {
        System.out.println(this.name + " says beeeee !");

    }

    public String toString() {
        return "Sheep named " + this.name + " is owned by " + this.owner;
    }


}
