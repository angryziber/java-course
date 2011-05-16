package net.azib.java.students.t107678.homework;

import java.io.Closeable;
import java.io.PrintStream;
import java.util.ArrayList;

import static java.lang.System.*;

public class ConsoleWriter implements Writer {

    final private PrintStream writer;
    final static String COMA_FIELD = ",";


    public ConsoleWriter() {
        writer = out;
    }

    @Override
    public void writeNext(int place, Record record) {
        String output = "Place: " + String.valueOf(place+1) + " Score: " + String.valueOf(record.getTotalPoints()) + " Name: " + record.getParticipant().getName() + " Coming from " + record.getParticipant().getCountry().getValue();
        writer.println(output);
        output = "";

        for (Event e : record.getEvents()) {
            output = e.getEventName() + " : " + String.valueOf(e.getPerformance()) + " " +e.getEventUnits();
            writer.println(output);
            output = "";
        }

        System.out.println("___________________________________________________________________");
    }


    @Override
    public void writeOutput(ResultsComputation resultsComputation) {
        ArrayList<Record> records = resultsComputation.getRecords();
        for (Record record : records) {
            writeNext(records.indexOf(record), record);
        }
        writer.close();

    }

}
