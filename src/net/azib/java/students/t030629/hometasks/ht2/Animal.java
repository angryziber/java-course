package net.azib.java.students.t030629.hometasks.ht2;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 25.02.2008
 * <br>Time: 13:26:11
 */
public abstract class Animal {

    protected String name;
    protected byte age;

    protected Animal(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Checks if the animal can fly.
     * @return <tt>true</tt> if the animal can fly. <tt>false</tt> otherwise.
     */
    abstract boolean canFly();

    /**
     * Queries for the class of the animal.
     * @return a string representing the class of the animal
     */
    abstract AnimalClass getAnimalClass();

    /**
     * Queries for additional info for the given animal.
     * @return some additional info if any
     */
    abstract String getAdditionalInfo();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animal class: ").append(getAnimalClass()).append(". ");
        sb.append("Name: ").append(name).append(". ");
        sb.append("Age: ").append(age).append(". ");
        sb.append(canFly() ? "Can fly" : "Cannot fly").append(". ");
        sb.append("Additional info: ").append(getAdditionalInfo());
        return sb.toString();
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }
}
