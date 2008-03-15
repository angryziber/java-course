package net.azib.java.students.t030629.hometasks.ht2;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 25.02.2008
 * <br>Time: 13:44:10
 */
public class Pigeon extends Animal {
    private static final AnimalClass ANIMAL_CLASS = AnimalClass.BIRD;

    protected Pigeon(String name, byte age) {
        super(name, age);
    }

    boolean canFly() {
        return true;
    }

    AnimalClass getAnimalClass() {
        return ANIMAL_CLASS;
    }

    String getAdditionalInfo() {
        return "";
    }

}
