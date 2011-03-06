package net.azib.java.students.t107678.hw2;

public abstract class Animal {
    private int age = -1;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void becomeOlder() {
        age++;

    }

    public abstract void makeSound();


}

