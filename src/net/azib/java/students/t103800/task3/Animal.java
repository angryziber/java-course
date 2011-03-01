package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:10
 */
public abstract class Animal {

    private int ageInYears;

    public Animal(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int newAgeInYears) {
        ageInYears = newAgeInYears;
    }

    public void makeOlder(int howManyYears) {
        ageInYears += howManyYears;
    }

    public void makeSound() {
    }

}