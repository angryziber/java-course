package net.azib.java.students.t107678.hw2;

public class AnimalDemo {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Sharky");
        Dog dog2 = new Dog("Snoopy", 3, true);
        Dog dog3 = new Dog("Ben", 4);
        Dog dog4 = new Dog("Snoopy", 2, false);
        Cat cat1 = new Cat("Lisa");
        Cat cat2 = new Cat("Lola", 7, true);
        Sheep sheep1 = new Sheep("Dolly", "Romero");


        Animal[] animals = {dog1, dog2, dog3, dog4, cat1, cat2, sheep1};
        for (Animal animal : animals) {
            System.out.println(animal.toString());
            animal.makeSound();
            System.out.println();
        }


    }
}
