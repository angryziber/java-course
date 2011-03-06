package net.azib.java.students.t107678.hw2;

public class Dog extends Pet {

    public Dog(String dogName) {
        this.name = dogName;
    }

    public Dog(String dogName, int dogAge) {
        this.name = dogName;
        this.setAge(dogAge);
    }

    public Dog(String dogName, int dogAge, boolean haveCollar) {
        this.name = dogName;
        this.setAge(dogAge);
        this.setHaveCollar(haveCollar);
    }

    public Dog(String dogName, boolean haveCollar) {
        this.name = dogName;
        this.setHaveCollar(haveCollar);
    }

    public void makeSound() {
        System.out.println(name + " says wuf !");

    }

    public String toString() {
        if (this.isHaveCollar()) {
            if (this.getAge() >= 0)
                return "Dog named " + name + " has collar and it is " + this.getAge() + " years old.";
            else
                return "Dog named " + name + " has collar ";
        } else if (this.getAge() >= 0)
            return "Dog named " + name + " and doesn't have collar and it is " + this.getAge() + " years old.";
        else
            return "Dog named " + name + " and doesn't have collar";


    }


}
