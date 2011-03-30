package net.azib.java.students.t104971.chars;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleInput {

    private static BufferedReader console;
    private static Logger LOG = Logger.getLogger(ConsoleInput.class);

    private static BufferedReader getConsole() {
        return console == null ? console = new BufferedReader(new InputStreamReader(System.in)) : console;
    }

    public String getLine() {
        String currentLine = "";
        while ("".equalsIgnoreCase(currentLine)) {
            try {
                currentLine = getConsole().readLine();
            } catch (IOException e) {
                LOG.error(e);
            }
            if ("".equals(currentLine)) {
                LOG.warn("The input cannot be empty!\n");
            }
        }
        return currentLine;
    }
}
