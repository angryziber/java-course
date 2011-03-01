package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:14
 */
public abstract class Pet extends Animal {

    private String name, owner;

    public Pet(String petName, int ageInYears, String ownerName) {
        super(ageInYears);
        name = petName;
        owner = ownerName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return owner;
    }

    public void getANewOwner(String newOwnerName) {
        owner = newOwnerName;
    }

}