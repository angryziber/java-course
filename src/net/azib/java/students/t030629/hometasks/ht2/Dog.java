package net.azib.java.students.t030629.hometasks.ht2;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 25.02.2008
 * <br>Time: 13:38:49
 */
public class Dog extends Animal {
    private static final AnimalClass ANIMAL_CLASS = AnimalClass.MAMMAL;
    private int legsCount;

    protected Dog(String name, byte age, int legsCount) {
        super(name, age);
        this.legsCount = legsCount;
    }

    boolean canFly() {
        return false;
    }

    String getAnimalClass() {
        return ANIMAL_CLASS.toString();
    }

    String getAdditionalInfo() {
        return legsCount == 4 ? "Runs fast! Be careful!" : "Runs slow. May bite though!";
    }
}
