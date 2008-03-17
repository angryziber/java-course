package net.azib.java.students.t030629.hometasks.ht5;

import java.util.Scanner;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 17.03.2008
 * <br>Time: 12:08:25
 */
public class BinaryParser {
    private final static String NUMBER_ENTERING_MESSAGE = "Enter space-separated binary number(s): ";
    private final static String SPLITTING_REGEX = "\\s";
    private final static String TERMINATING_REGEX = "[Xx]";

    private Scanner scanner;
    private PrintStream out;

    public BinaryParser() {
        this(System.in, System.out);
    }

    public BinaryParser(InputStream in, PrintStream out){
        scanner = new Scanner(in);
        this.out = out;
    }

    public void listen() {

        out.println(NUMBER_ENTERING_MESSAGE);
        main: while (true) {
            /* Read numbers from standard input */
            String[] binNumbersAsString = read();
            /* Process read numbers */
            for (String binNumber : binNumbersAsString) {
                if (binNumber.matches(TERMINATING_REGEX)) break main;
                display(binNumber);
            }

        }
    }

    private String[] read(){
        return scanner.nextLine().split(SPLITTING_REGEX);
    }

    private void display(String binNumberAsString){
        int decimalNumber = Integer.parseInt(binNumberAsString, 2);
        out.println(binNumberAsString + ":  " + decimalNumber + ",  " + Integer.toHexString(decimalNumber));
    }

    public static void main(String[] args) {
        new BinaryParser().listen();
    }
}
