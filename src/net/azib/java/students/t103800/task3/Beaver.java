package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:12
 */
public class Beaver extends Animal {

    private int treesCut;

    public Beaver() {
        super(0);
    }

    /**
     * Creates a new beaver.
     * @param ageInYears How old is this beaver?
     * @param treesCutDown How many trees did this beaver destroy?
     */
    public Beaver(int ageInYears, int treesCutDown) {
        super(ageInYears);
        this.treesCut = treesCutDown;
    }

    public int howManyTreesCut() {
        return treesCut;
    }

    public void cutATree() {
        treesCut++;
    }

    public void cutNumberOfTrees(int numberOfTrees) {
        treesCut += numberOfTrees;
    }

    public void makeSound() {
        System.out.println("OOOOOOuuugg!");
    }

    public String toString() {
        return "[Type: Beaver(Animal)][Age: " + super.getAgeInYears() + " years]" +
                "[Trees cut: " + treesCut + "]";
    }

}