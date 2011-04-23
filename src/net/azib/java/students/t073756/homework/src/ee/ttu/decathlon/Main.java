package ee.ttu.decathlon;

public class Main {

    private static final Controller controller = new Controller();

    public static void main(String[] args) {
        System.out.println("Welcome to decathlon points calculation system!");
        if (args.length < 0) {
            throw new DecathlonException("please provide program arguments");
        }
        controller.doService(args);
    }
}
