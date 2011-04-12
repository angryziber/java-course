package net.azib.java.students.t104971.homework.athletics.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Jaroslav Judin
 */
public class InputRead {

    public ArrayList<String> getContents(InputStream inputStream) {

        ArrayList<String> contents = new ArrayList<String>();
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String line;
                while ((line = input.readLine()) != null) {
                    if (line.length() > 0)
                        contents.add(line);
                }
            } finally {
                input.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(getClass()).error("Error in file reading", ex);
        }

        return contents;
    }

}
