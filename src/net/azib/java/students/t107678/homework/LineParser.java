package net.azib.java.students.t107678.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides logic for parsing and validating of one input line
 */
public class LineParser {
    final private static int RECORD_MEMBER_COUNT = 13;
    private static final String COLON = ":";

    /**
     *
     * @param line represents one coma separated line from input source
     * @return Record for singe participant
     * @throws RecordFormatException Input string should contain 13 coma separated values
     */
    public Record parseLine(String line) throws RecordFormatException {
        String[] parts = line.split(",");

        if (parts.length != RECORD_MEMBER_COUNT) {
            throw new RecordFormatException("Record should consist from 13 data inputs");
        }

        Pattern pattern = Pattern.compile("^\"([^\\\"]+)\"$");
        Matcher matcher = pattern.matcher(parts[0]);

        if (!matcher.matches()) {
            throw new RecordFormatException("Name field does not match expectation");
        }

        if(!ValidationOfUserInputData.validateName(matcher.group(1))){
            throw new RecordFormatException("Invalid name of participant");

        }


        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date;
        try {
            date = format.parse(parts[1]);
        } catch (ParseException e) {
            throw new RecordFormatException(e);
        }

        if(!ValidationOfUserInputData.validateCountryCode(parts[2])){
            throw new RecordFormatException("Invalid country code");
        }
        CountryCode code = new CountryCode(parts[2]);

        Collection<Event> participantResults = new ArrayList(10);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[3])){
            throw new RecordFormatException("Invalid HundredMetersEvent data");
        }

        HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(Double.parseDouble(parts[3]));
        participantResults.add(hundredMetersEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[4])){
            throw new RecordFormatException("Invalid LongJumpEvent data");
        }

        LongJumpEvent longJumpEvent = new LongJumpEvent(Double.parseDouble(parts[4]));
        participantResults.add(longJumpEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[5])){
            throw new RecordFormatException("Invalid ShotPutEvent data");
        }

        ShotPutEvent shotPutEvent = new ShotPutEvent(Double.parseDouble(parts[5]));
        participantResults.add(shotPutEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[6])){
            throw new RecordFormatException("Invalid HighJumpEvent data");
        }

        HighJumpEvent highJumpEvent = new HighJumpEvent(Double.parseDouble(parts[6]));
        participantResults.add(highJumpEvent);

        if(!ValidationOfUserInputData.validateMinColonSecEvent(parts[7])){
            throw new RecordFormatException("Invalid FourHundredMetersEvent data");
        }

        // need to transform min:sec to double

        String[] FirstMinAndSecString = parts[7].split(COLON);

        Double FirstMinAndSecDouble = Double.parseDouble(FirstMinAndSecString[0]) * 60.0 + Double.parseDouble(FirstMinAndSecString[1]);

        FourHundredMetersEvent fourHundredMetersEvent = new FourHundredMetersEvent(FirstMinAndSecDouble);
        participantResults.add(fourHundredMetersEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[8])){
            throw new RecordFormatException("Invalid OneHundredTenHurdleseEvent data");
        }

        OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(Double.parseDouble(parts[8]));
        participantResults.add(oneHundredTenHurdleseEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[9])){
            throw new RecordFormatException("Invalid DiscusThrowEvent data");
        }

        DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(Double.parseDouble(parts[9]));
        participantResults.add(discusThrowEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[10])){
            throw new RecordFormatException("Invalid PoleVaultEvent data");
        }

        PoleVaultEvent poleVaultEvent = new PoleVaultEvent(Double.parseDouble(parts[10]));
        participantResults.add(poleVaultEvent);

        if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(parts[11])){
            throw new RecordFormatException("Invalid JavelinThrowEvent data");
        }

        JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(Double.parseDouble(parts[11]));
        participantResults.add(javelinThrowEvent);

//        if(!ValidationOfUserInputData.validateMinColonSecEvent(parts[12])){                   //TODO it passed unit test but it doesn't work in real? WTF?
//            throw new RecordFormatException("Invalid ThousandFiveHundredMetersEvent data");
//        }

        String[] SecondMinAndSecString = parts[12].split(COLON);
        Double SecondMinAndSecDouble = Double.parseDouble(SecondMinAndSecString[0]) * 60 + Double.parseDouble(SecondMinAndSecString[1]);

        ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(SecondMinAndSecDouble);
        participantResults.add(thousandFiveHundredMetersEvent);


        Participant participant = new Participant(matcher.group(1), date, code);


        return new Record(participant, participantResults);
    }

}
