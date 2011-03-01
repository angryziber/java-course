package net.azib.java.students.t103800.task3;

/**
 * User: Jaan Aigro 103800
 * Date: 19.02.11
 * Time: 23:09
 */
public class AnimalsDemo {

    public static void main(String[] args) {
        Animal animals[] = new Animal[8];
        animals[0] = new Beaver();
        animals[1] = new Beaver(4, 1920);
        animals[2] = new Horse();
        animals[3] = new Horse("Thunderbolt", "mr Skull", 10, 32000);
        animals[4] = new Kitty();
        animals[5] = new Kitty("Powerpuff", "pinky", "miss Gaga", 2);
        animals[6] = new Wolf();
        animals[7] = new Wolf(5, true);

        System.out.println("Lets get familiar with our freshly created animals:\n");

        for (Animal a : animals) {
            System.out.println(a);
            System.out.print("This animal sounds like: ");
            a.makeSound();
            System.out.println();
        }
    }

}
