package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class LineParserTest {



    @Test
    public void testParseLine() throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse("21.10.1980");
        ArrayList<Event> eventCollections = new ArrayList<Event>(10);

        HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(13.43);
        eventCollections.add(hundredMetersEvent);
        LongJumpEvent longJumpEvent = new LongJumpEvent(4.35);
        eventCollections.add(longJumpEvent);
        ShotPutEvent shotPutEvent = new ShotPutEvent(8.64);
        eventCollections.add(shotPutEvent);
        HighJumpEvent highJumpEvent = new HighJumpEvent(1.50);
        eventCollections.add(highJumpEvent);
        FourHundredMetersEvent fourHundredMetersEvent = new FourHundredMetersEvent(66.06);
        eventCollections.add(fourHundredMetersEvent);
        OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(19.05);
        eventCollections.add(oneHundredTenHurdleseEvent);
        DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(24.89);
        eventCollections.add(discusThrowEvent);
        PoleVaultEvent poleVaultEvent = new PoleVaultEvent(2.20);
        eventCollections.add(poleVaultEvent);
        JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(33.48);
        eventCollections.add(javelinThrowEvent);
        ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(411.01);
        eventCollections.add(thousandFiveHundredMetersEvent);

        Participant participant = new Participant("Василий Пупкин",date,new CountryCode("ua"));
        Record  record = new Record(participant,eventCollections);

        String line = "\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";

        LineParser lineParser = new LineParser();
        Record lineParserCreatedRecord = lineParser.parseLine(line);

        assertEquals(record.getParticipant().getName(),lineParserCreatedRecord.getParticipant().getName());
        assertEquals(record.getParticipant().getBirthDate(),lineParserCreatedRecord.getParticipant().getBirthDate());
        assertEquals(record.getParticipant().getCountry(),lineParserCreatedRecord.getParticipant().getCountry());
        assertSame(record.getEvents().size(), lineParserCreatedRecord.getEvents().size());



    }
}
