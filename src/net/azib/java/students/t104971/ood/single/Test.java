package net.azib.java.students.t104971.ood.single;

public class Test {
    public static void main(String[] args) {
        SingleInstance instance = SingleInstance.getInstance();
        System.out.println(instance);
        instance  = SingleInstance.getInstance();
        System.out.println(instance);
    }
}
