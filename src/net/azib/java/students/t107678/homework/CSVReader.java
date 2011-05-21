package net.azib.java.students.t107678.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Logic for reading data from file
 *
 */
public class CSVReader implements Reader {

    final private BufferedReader reader;


    public CSVReader(String fileName) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(fileName));
    }

    public Record getNext() throws IOException, RecordFormatException {

        String line = reader.readLine();

        if (line == null) {
            return null;
        }

        return new LineParser().parseLine(line);
    }


}

