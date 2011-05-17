package net.azib.java.students.t107678.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {

    final static String COMA_FIELD = ",";
    final static String DOUBLE_QUOTE = "\"";


    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStreamReader);

    /**
     * default constructor
     */
    public ConsoleReader() {
    }

    /** Empty input strings should not be inputed
     *
     * @return nonempty string value inputed by used
     * @throws IOException
     */
    public String returnIfNotEmpty() throws IOException {
        String value = "";
        do {
            value = reader.readLine();
        } while (value.length() == 0);
        return value;
    }

    /** Concatenates part by part participant data into one line
     *
     * @return String which represents complete participant Decathlon data
     * @throws IOException
     */
    public String readRecordManualy() throws IOException {

        String recordRawData = "";
        System.out.println("Please enter participant Name: ");
        recordRawData = recordRawData + DOUBLE_QUOTE + returnIfNotEmpty() + DOUBLE_QUOTE + COMA_FIELD;
        System.out.println("Please enter participant BirthDate [dd.MM.yyyy]: ");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant CountryCode [ISO 2-letter code]: ");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 100m SprintEvent [sec]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from LongJumpEvent [m]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from ShotPutEvent [m]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from HighJumpEvent [m]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 400mEvent [min:sec]");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 110mHurdlesEvent [sec]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from DiscusThrowEvent [m]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from PoleVaultEvent [m]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from JavelinThrowEvent [m]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant performance from 1500mRaceEvent [min:sec]:");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Record successfully enter !");

        //validate entered record ! return to beginning if not ok

        return recordRawData;
    }

    /**
     *
     * @return Participant record
     * @throws IOException
     * @throws RecordFormatException
     */
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
