package net.azib.java.students.t107678.hw2;

public class Cat extends Pet {

    public Cat(String catName) {
        this.name = catName;
    }

    public Cat(String catName, int catAge) {
        this.name = catName;
        this.setAge(catAge);
    }

    public Cat(String catName, int catAge, boolean haveCollar) {
        this.name = catName;
        this.setAge(catAge);
        this.setHaveCollar(haveCollar);
    }

    public Cat(String catName, boolean haveCollar) {
        this.name = catName;
        this.setHaveCollar(haveCollar);
    }

    public void makeSound() {
        System.out.println(name + " says mau !");

    }

    public String toString() {
        if (this.isHaveCollar()) {
            if (this.getAge() >= 0)
                return "Cat named " + name + " has collar and it is " + this.getAge() + " years old.";
            else
                return "Cat named " + name + " has collar ";
        } else if (this.getAge() >= 0)
            return "Cat named " + name + " and doesn't have collar and it is " + this.getAge() + " years old.";
        else
            return "Cat named " + name + " and doesn't have collar";


    }


}
