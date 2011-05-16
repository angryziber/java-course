package net.azib.java.students.t107678.homework;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DataBaseReader implements Reader{

    DataBaseConnector connector;
    ResultSet set;
    static final String statement = "select a.name, a.dob, a.country_code, r.race_100m, r.long_jump,r.shot_put,r.high_jump,r.race_400m," +
            " r.hurdles_110m, r.discus_throw, r.pole_vault, r.javelin_throw, r.race_1500m from athletes a, results r " +
            "where a.id=r.athlete_id and r.competition_id=";


    public DataBaseReader(DataBaseConnector connector,String competitionId) {
        this.connector = connector;
        this.set = connector.executeSelect(statement+competitionId);
    }


    @Override
    public Record getNext() throws IOException, RecordFormatException, SQLException {
        if (set.next()){

            Collection<Event> participantResults = new ArrayList(10);


            String name = set.getString(1);
            Date birthDate = set.getDate(2);
            CountryCode countryCode = new CountryCode(set.getString(3));
            HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(set.getDouble(4));
            participantResults.add(hundredMetersEvent);
            LongJumpEvent longJumpEvent = new LongJumpEvent(set.getDouble(5));
            participantResults.add(longJumpEvent);
            ShotPutEvent shotPutEvent = new ShotPutEvent(set.getDouble(6));
            participantResults.add(shotPutEvent);
            HighJumpEvent highJumpEvent = new HighJumpEvent(set.getDouble(7));
            participantResults.add(highJumpEvent);
            FourHundredMetersEvent fourHundredMetersEvent = new FourHundredMetersEvent(set.getDouble(8));
            participantResults.add(fourHundredMetersEvent);
            OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(set.getDouble(9));
            participantResults.add(oneHundredTenHurdleseEvent);
            DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(set.getDouble(10));
            participantResults.add(discusThrowEvent);
            PoleVaultEvent poleVaultEvent = new PoleVaultEvent(set.getDouble(11));
            participantResults.add(poleVaultEvent);
            JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(set.getDouble(12));
            participantResults.add(javelinThrowEvent);
            ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(set.getDouble(13));
            participantResults.add(thousandFiveHundredMetersEvent);

            Participant participant = new Participant(name, birthDate,countryCode);

            return new Record(participant,participantResults);

        }
        return null;
    }
}
