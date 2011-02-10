package net.azib.java.lessons.basic;

public class MoneyDemo {
    public static void main(String[] args) {
        float balance = 1;
        balance -= 0.1;

        System.out.println(balance);
        boolean isEnough = balance >= 0.9;
        System.out.println("Enough for another beer? " + isEnough);
    }
}
