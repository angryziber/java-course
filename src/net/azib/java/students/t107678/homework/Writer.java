package net.azib.java.students.t107678.homework;

import java.io.Closeable;
import java.util.ArrayList;

public interface Writer {

    // public void writeNext();
    public abstract void writeNext(int place, Record record);

    public void writeOutput(ResultsComputation resultsComputation);
}
