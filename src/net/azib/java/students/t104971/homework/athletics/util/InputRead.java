package net.azib.java.students.t104971.homework.athletics.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Jaroslav Judin
 *
 */
public class InputRead {

    /**
     * Fetch the entire contents of a text file, and return it in a String.
     * This style of implementation does not throw Exceptions to the caller.
     *
     * @param aFile is a file which already exists and can be read.
     * @return
     */
    public ArrayList<String> getContents(File aFile) {

        ArrayList<String> contents = new ArrayList<String>();

        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            BufferedReader input = new BufferedReader(new FileReader(aFile));
            try {
                String line = null; //not declared within while loop
                /*
                * readLine is a bit quirky :
                * it returns the content of a line MINUS the newline.
                * it returns null only for the END of the stream.
                * it returns an empty String if two newlines appear in a row.
                */
                while ((line = input.readLine()) != null) {
                    if (line.length()>0)
                    	contents.add(line);
                }
            }
            finally {
                input.close();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return contents;
    }

}
