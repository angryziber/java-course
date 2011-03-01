package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:15
 */
public class Horse extends Pet {

    private int kmTravelled;

    public Horse() {
        super("Nameless", 0, "mr Greatheart");
        kmTravelled = 0;
    }

    /**
     * Horse.
     * @param name Name of the horse.
     * @param owner Owners name.
     * @param ageInYears Age of the horse.
     * @param kmTravelled Travel distance in kilometres.
     */
    public Horse(String name, String owner, int ageInYears, int kmTravelled) {
        super(name, ageInYears, owner);
        this.kmTravelled = kmTravelled;
    }

    public void travel(int howManyKm) {
        kmTravelled += howManyKm;
    }

    public int getKmTravelled() {
        return kmTravelled;
    }

    public void makeSound() {
        System.out.println("Pfff.. Neigh!");
    }

    public String toString() {
        return "[Type: Horse(Animal, Pet)][Age: " + super.getAgeInYears() + " years]" +
                "[Name: " + super.getName() + "][Owner: " + super.getOwnerName() + "]" +
                "[Trav.dist: " + kmTravelled + " km]";
    }
}
