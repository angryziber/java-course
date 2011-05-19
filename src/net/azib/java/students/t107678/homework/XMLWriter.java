package net.azib.java.students.t107678.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class XMLWriter implements Writer {

    final private PrintWriter writer;


    public XMLWriter(String fileName) throws IOException {
        this.writer = new PrintWriter(new FileWriter(fileName));

    }

    @Override
    public void writeNext(Place place, Record record) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void writeOutput(ResultsComputation resultsComputation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
