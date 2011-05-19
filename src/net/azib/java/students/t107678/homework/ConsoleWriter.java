package net.azib.java.students.t107678.homework;

import java.io.PrintStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static java.lang.System.*;

public class ConsoleWriter implements Writer {

    final private PrintStream writer;

    public ConsoleWriter() {
        writer = out;
    }

    /**
     * This method will print out final results only for singe Participant
     *
     * @param place  achieved place according to results
     * @param record Participant record
     */
    @Override
    public void writeNext(Place place, Record record) {

        Format format = new SimpleDateFormat("dd.MM.yyyy");

        //String.valueOf(place + 1)

        String output = "Place: " + place.getFinalPlace() + " Score: " + String.valueOf(record.getTotalPoints()) + " Name: " + record.getParticipant().getName() + " Born on: " + format.format(record.getParticipant().getBirthDate()).toString() + " Coming from " + record.getParticipant().getCountry().getValue();
        writer.println(output);
        output = "";

        for (Event e : record.getEvents()) {
            output = e.getEventName() + " : " + String.valueOf(e.getPerformance()) + " " + e.getEventUnits();
            writer.println(output);
            output = "";
        }

        System.out.println("___________________________________________________________________");
    }

    /**
     * This method will print out final competition results for all Participants
     *
     * @param resultsComputation instance which contains relevant Decathlon computation results
     */
    @Override
    public void writeOutput(ResultsComputation resultsComputation) {

        ArrayList<Record> records = resultsComputation.getRecords();

        System.out.println("Dechatlon competition results".toUpperCase());
        System.out.println("--------------------------------------------------------------------");

//        for (Record record : records) {
//            writeNext(records.indexOf(record), record);
//        }
//

        // 2-4 issue
        Record tempRecord;

        for (int i = 0; i < records.size(); i++) {
            int sharesWith = 0;
            tempRecord = records.get(i);
            //writeNext(records.indexOf(tempRecord), tempRecord);
            int j = i;
            while ((i < records.size() - 1) && (tempRecord.getTotalPoints() == records.get(i + 1).getTotalPoints())) {
                sharesWith++;
                i = i + 1;
                tempRecord = records.get(i);
                // writeNext(j, tempRecord);
            }
            for(int k=j; k<=i; k++){
                writeNext(new Place(j+1,sharesWith), records.get(k));  //j+1 because of indexing from 0 bug
            }

        }


        writer.close();

    }

}
