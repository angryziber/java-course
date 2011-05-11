package net.azib.java.students.t104971.homework.athletics.io.input;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Jaroslav Judin
 */
public class ConsoleInput {

    BufferedReader console;

    BufferedReader getConsole() {
        return console == null ? console = new BufferedReader(new InputStreamReader(System.in)) : console;
    }

    public String getLine() {
        String currentLine = "";
        while ("".equalsIgnoreCase(currentLine)) {
            try {
                currentLine = getConsole().readLine();
            } catch (IOException e) {
                Logger.getLogger(ConsoleInput.class).error(e);
            }
            if ("".equals(currentLine)) {
                System.out.println("The input cannot be empty!\n");
            }
        }
        return currentLine;
    }
}
