package net.azib.java.students.t030629.hometasks.ht2;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 25.02.2008
 * <br>Time: 13:44:30
 */
public class TestAnimal {

    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Dog("Tuzik", (byte) 17, 4),
                new Dog("Tsheini", (byte) 4, 3),
                new Pigeon("Piggy", (byte) 2)
        };

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
