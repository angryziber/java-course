package net.azib.java.students.t104971.ood.single;

/**
 * @author Jaroslav Judin
 */
public class SingleInstance {

    private static SingleInstance instance;

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        if (instance == null) {
            instance = new SingleInstance();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Hello, world " + super.toString();
    }
}
