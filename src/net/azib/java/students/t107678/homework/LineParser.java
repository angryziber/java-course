package net.azib.java.students.t107678.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides logic for parsing of one input line
 */
public class LineParser {
    final private static int RECORD_MEMBER_COUNT = 13;
    private static final String REGEX = ":";

    /**
     *
     * @param line represents one soma separated line from input sourse
     * @return Record for singe participant
     * @throws RecordFormatException Input string should contain 13 coma separated values
     */
    public Record parseLine(String line) throws RecordFormatException {
        String[] parts = line.split(",");

        if (parts.length != RECORD_MEMBER_COUNT) {
            throw new RecordFormatException("TODO");
        }

        Pattern pattern = Pattern.compile("^\"([^\\\"]+)\"$");
        Matcher matcher = pattern.matcher(parts[0]);

        if (!matcher.matches()) {
            throw new RecordFormatException("Name field does not match expectation");
        }

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date;
        try {
            date = format.parse(parts[1]);
        } catch (ParseException e) {
            throw new RecordFormatException(e);
        }

        CountryCode code = new CountryCode(parts[2]);

        Collection<Event> participantResults = new ArrayList(10);

        HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(Double.parseDouble(parts[3]));
        participantResults.add(hundredMetersEvent);

        LongJumpEvent longJumpEvent = new LongJumpEvent(Double.parseDouble(parts[4]));
        participantResults.add(longJumpEvent);

        ShotPutEvent shotPutEvent = new ShotPutEvent(Double.parseDouble(parts[5]));
        participantResults.add(shotPutEvent);

        HighJumpEvent highJumpEvent = new HighJumpEvent(Double.parseDouble(parts[6]));
        participantResults.add(highJumpEvent);

        // need to transform min:sec to double

        String[] FirstMinAndSecString = parts[7].split(REGEX);

        Double FirstMinAndSecDouble = Double.parseDouble(FirstMinAndSecString[0]) * 60.0 + Double.parseDouble(FirstMinAndSecString[1]);

        FourHundredMetersEvent fourHundredMetersEvent = new FourHundredMetersEvent(FirstMinAndSecDouble);
        participantResults.add(fourHundredMetersEvent);

        OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(Double.parseDouble(parts[8]));
        participantResults.add(oneHundredTenHurdleseEvent);

        DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(Double.parseDouble(parts[9]));
        participantResults.add(discusThrowEvent);

        PoleVaultEvent poleVaultEvent = new PoleVaultEvent(Double.parseDouble(parts[10]));
        participantResults.add(poleVaultEvent);

        JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(Double.parseDouble(parts[11]));
        participantResults.add(javelinThrowEvent);

        String[] SecondMinAndSecString = parts[12].split(REGEX);
        Double SecondMinAndSecDouble = Double.parseDouble(SecondMinAndSecString[0]) * 60 + Double.parseDouble(SecondMinAndSecString[1]);

        ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(SecondMinAndSecDouble);
        participantResults.add(thousandFiveHundredMetersEvent);


        Participant participant = new Participant(matcher.group(1), date, code);


        return new Record(participant, participantResults);
    }

}
