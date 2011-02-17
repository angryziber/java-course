package net.azib.java.lessons.basic;

public class ReferenceDemo {
    public static String global = "global";

    public static void main(String[] args) {
        Dog dog1 = new Dog("Snoopy");

        Dog dog2 = dog1;
        System.out.println(dog2.name);

        System.out.println(ReferenceDemo.global);
    }
}
