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

    /**
     * Empty input strings should not be inputed
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

    /**
     * Concatenates part by part participant data into one line
     *
     * @return String which represents complete participant Decathlon data
     * @throws IOException
     */
    public String readRecordManualy() throws IOException {

        String tempName = "";
        String tempBirthDate = "";
        String tempCountryCode = "";
        String tempMetersOrSecEvent = "";
        String tempMinColonSecEvent = "";

        String recordRawData = "";
        System.out.println("Please enter participant Name: ");
        recordRawData = recordRawData + DOUBLE_QUOTE + returnIfNotEmpty() + DOUBLE_QUOTE + COMA_FIELD;
        System.out.println("Please enter participant BirthDate [dd.MM.yyyy]: ");
        recordRawData = recordRawData + returnIfNotEmpty() + COMA_FIELD;
        System.out.println("Please enter participant CountryCode [ISO 2-letter code]: ");
        do {
            tempCountryCode = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateCountryCode(tempCountryCode) == false);
        recordRawData = recordRawData + tempCountryCode + COMA_FIELD;
        System.out.println("Please enter participant performance from 100m SprintEvent [sec]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from LongJumpEvent [m]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from ShotPutEvent [m]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from HighJumpEvent [m]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from 400mEvent [min:sec]");
        do {
            tempMinColonSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMinColonSecEvent(tempMinColonSecEvent) == false);
        recordRawData = recordRawData + tempMinColonSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from 110mHurdlesEvent [sec]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from DiscusThrowEvent [m]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from PoleVaultEvent [m]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from JavelinThrowEvent [m]:");
        do {
            tempMetersOrSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMetersOrSecondsEvent(tempMetersOrSecEvent) == false);
        recordRawData = recordRawData + tempMetersOrSecEvent + COMA_FIELD;
        System.out.println("Please enter participant performance from 1500mRaceEvent [min:sec]:");
        do {
            tempMinColonSecEvent = returnIfNotEmpty();

        } while (ValidationOfUserInputData.validateMinColonSecEvent(tempMinColonSecEvent) == false);
        recordRawData = recordRawData + tempMinColonSecEvent + COMA_FIELD;

        System.out.println("Record successfully enter !");


        return recordRawData;
    }

    /**
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
