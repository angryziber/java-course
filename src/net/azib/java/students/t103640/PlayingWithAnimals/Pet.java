package net.azib.java.students.t103640.PlayingWithAnimals;

public abstract class Pet extends Animal {
    private String name;
    public Pet(int age,  String name) {
        super(age);
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
