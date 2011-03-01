package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:13
 */
public class Wolf extends Animal {

    private boolean hungry;

    public Wolf() {
        super(0);
        hungry = false;
    }

    /**
     * Cruel wolf.
     * @param ageInYears Age of the wolf.
     * @param isHungry Set true if you want to make your wolf hungry.
     */
    public Wolf(int ageInYears, boolean isHungry) {
        super(ageInYears);
        hungry = isHungry;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void makeHungry() {
        hungry = true;
    }

    public void makeSound() {
        System.out.println("Woof, woof!");
    }

    public String toString() {
        return "[Type: Wolf(Animal)][Age: " + super.getAgeInYears() + " years]" +
                "[Hungry: " + hungry + "]";
    }

}