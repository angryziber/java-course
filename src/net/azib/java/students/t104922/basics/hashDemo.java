package net.azib.java.students.t104922.basics;

public class hashDemo {
    public static void main(String[] args) {

        System.out.println("Hashed code is =" + calculate_hash("012"));

    }

    public static int calculate_hash(String input) {
            int h = 0;
            int len = input.length();
            for (int i = 0; i < len; i++) {
                h = 31 * h + input.charAt(i);
            }
            return h;
        }
}
