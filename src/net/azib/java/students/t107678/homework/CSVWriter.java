package net.azib.java.students.t107678.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CSVWriter implements Writer {

    final private PrintWriter writer;
    final static String COMA_FIELD = ",";


    public CSVWriter(String fileName) throws IOException {
        this.writer = new PrintWriter(new FileWriter(fileName));
    }


    @Override
    public void writeNext(int place, Record record) {

        Format format = new SimpleDateFormat("dd.MM.yyyy");

        String output = String.valueOf(place+1) + COMA_FIELD + String.valueOf(record.getTotalPoints())+
                COMA_FIELD +  record.getParticipant().getName() + COMA_FIELD + format.format(record.getParticipant().getBirthDate())+ COMA_FIELD + record.getParticipant().getCountry().getValue() + COMA_FIELD ;

        for (Event e : record.getEvents()) {
            output=output+String.valueOf(e.getPerformance()) + COMA_FIELD;
            }

        writer.println(output);
    }

    @Override
    public void writeOutput(ResultsComputation resultsComputation) {


        ArrayList<Record> records = resultsComputation.getRecords();

//        for (Record record : records) {
//           writeNext(records.indexOf(record), record);
//        }

        // 2-4 issue
        Record tempRecord;
        for(int i = 0;i<records.size();i++){
               tempRecord= records.get(i);
            writeNext(records.indexOf(tempRecord),tempRecord);
            int j = i;
            while ((i<records.size()-1) &&(tempRecord.getTotalPoints()==records.get(i+1).getTotalPoints())){
                i=i+1;
                tempRecord = records.get(i);
                writeNext(j,tempRecord);

            }
        }
        writer.close();

    }

}
