package net.azib.java.lessons.basic;

public class StaticDemo {
    Dog personalDog;
    static Dog sharedDog;

    public static void main(String ... args) {
        StaticDemo.sharedDog = new Dog("Homeless");

        StaticDemo owner1 = new StaticDemo();
        owner1.personalDog = new Dog("Snoopy");

        StaticDemo owner2 = new StaticDemo();
        owner2.personalDog = new Dog("Spoofy");

        System.out.println(owner2.sharedDog.name);
        System.out.println(owner1.sharedDog == owner2.sharedDog);

        System.out.println("owner1 owns " + owner1.personalDog.name);
        System.out.println("owner2 owns " + owner2.personalDog.name);
    }
}
