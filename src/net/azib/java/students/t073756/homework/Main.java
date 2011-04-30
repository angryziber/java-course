package net.azib.java.students.t073756.homework;

public class Main {
    private static final Controller controller = new Controller();

    public static void main(String[] args) {
        System.out.println("Welcome to decathlon points calculation system!");

        try {
            controller.doService(args);
        } catch (DecathlonException e) {
            System.out.println("Error! " + e.getMessage());
            System.exit(-1);
        }
    }
}
