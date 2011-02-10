package net.azib.java.lessons.basic;

public class PetOwner {
    Dog personalDog;
    static Dog sharedDog;

    public static void main(String[] args) {
        PetOwner.sharedDog = new Dog();
        PetOwner.sharedDog.name = "Homeless";

        PetOwner owner1 = new PetOwner();
        owner1.personalDog = new Dog();
        owner1.personalDog.name = "Snoopy";

        PetOwner owner2 = new PetOwner();
        owner2.personalDog = new Dog();
        owner2.personalDog.name = "Spoofy";

        System.out.println(owner2.sharedDog.name);
        System.out.println(owner1.sharedDog == owner2.sharedDog);

        System.out.println("owner1 owns " + owner1.personalDog.name);
        System.out.println("owner2 owns " + owner2.personalDog.name);
    }
}
