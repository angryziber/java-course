package net.azib.java.students.t107678.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    final static String COMA_FIELD = ",";
    final static String DOUBLE_QUOTE = "\"";


    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStreamReader);

    public ConsoleReader() {
    }

    public String returnIfNotEmpty() throws IOException {
        String value = "";
        do {
            value = reader.readLine();
        } while (value.length() == 0);
        return value;
    }

    public String readRecordManualy() throws IOException {

        String recordRawData = "";
        System.out.println("Please enter participant Name: ");
        recordRawData = recordRawData + DOUBLE_QUOTE + returnIfNotEmpty() + DOUBLE_QUOTE + COMA_FIELD;
        System.out.println("Please enter participant BirthDate");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant CountryCode");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 100mEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from LongJumpEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from ShotPutEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from HighJumpEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 400mEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 110mHurdlesEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from DiscusThrowEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from PoleVaultEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from JavelinThrowEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 1500mRaceEvent");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Record successfully enter !");

        return recordRawData;
    }


    @Override
    public Record getNext() throws IOException, RecordFormatException {
        String answer = "";
        String line = "";

            line = readRecordManualy();


        if (line == null) {
            return null;
        }

        return new LineParser().parseLine(line);

    }
}
