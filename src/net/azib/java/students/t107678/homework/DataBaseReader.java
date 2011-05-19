package net.azib.java.students.t107678.homework;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DataBaseReader implements Reader {

    DataBaseConnector connector;
    ResultSet set;
    static final String statement = "select a.name, a.dob, a.country_code, r.race_100m, r.long_jump,r.shot_put,r.high_jump,r.race_400m," +
            " r.hurdles_110m, r.discus_throw, r.pole_vault, r.javelin_throw, r.race_1500m from athletes a, results r " +
            "where a.id=r.athlete_id and r.competition_id=";


    /**
     * Normal scenario constructor
     *
     * @param connector     instance of DataBaseConnector
     * @param competitionId number of competition from database provided by user
     */
    public DataBaseReader(DataBaseConnector connector, String competitionId) {
        this.connector = connector;
        this.set = connector.executeSelect(statement + competitionId);      //TODO implement posibility of connection with competition_name
    }


    /**
     * This method "manually" assembles single Participant Record taken from one instance of ResultSet
     *
     * @return Single Participant Record data
     */
    @Override
    public Record getNext() throws IOException, RecordFormatException, SQLException {
        if (set.next()) {

            Collection<Event> participantResults = new ArrayList(10);

//            if (!ValidationOfUserInputData.validateName(set.getString(1))) {
//                throw new RecordFormatException("Invalid name of participant");
//            }
            String name = set.getString(1);

//            if(!ValidationOfUserInputData.validateBirthDate(set.getString(2))){
//                throw new RecordFormatException("Invalid birth date");
//            }
            Date birthDate = set.getDate(2);

            if(!ValidationOfUserInputData.validateCountryCode(set.getString(3))){
                throw new RecordFormatException("Invalid country code");
            }
            CountryCode countryCode = new CountryCode(set.getString(3));

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(4))){
                throw new RecordFormatException("Invalid HundredMetersEvent data");
            }
            HundredMetersEvent hundredMetersEvent = new HundredMetersEvent(set.getDouble(4));
            participantResults.add(hundredMetersEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(5))){
                throw new RecordFormatException("Invalid LongJumpEvent data");
            }
            LongJumpEvent longJumpEvent = new LongJumpEvent(set.getDouble(5));
            participantResults.add(longJumpEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(6))){
                throw new RecordFormatException("Invalid ShotPutEvent data");
            }
            ShotPutEvent shotPutEvent = new ShotPutEvent(set.getDouble(6));
            participantResults.add(shotPutEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(7))){
                throw new RecordFormatException("Invalid HighJumpEvent data");
            }
            HighJumpEvent highJumpEvent = new HighJumpEvent(set.getDouble(7));
            participantResults.add(highJumpEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(8))){
                throw new RecordFormatException("Invalid FourHundredMetersEvent data");
            }
            FourHundredMetersEvent fourHundredMetersEvent = new FourHundredMetersEvent(set.getDouble(8));
            participantResults.add(fourHundredMetersEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(9))){
                throw new RecordFormatException("Invalid OneHundredTenHurdleseEvent data");
            }
            OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(set.getDouble(9));
            participantResults.add(oneHundredTenHurdleseEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(10))){
                throw new RecordFormatException("Invalid DiscusThrowEvent data");
            }
            DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(set.getDouble(10));
            participantResults.add(discusThrowEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(11))){
                throw new RecordFormatException("Invalid PoleVaultEvent data");
            }
            PoleVaultEvent poleVaultEvent = new PoleVaultEvent(set.getDouble(11));
            participantResults.add(poleVaultEvent);

            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(12))){
                throw new RecordFormatException("Invalid JavelinThrowEvent data");
            }
            JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(set.getDouble(12));
            participantResults.add(javelinThrowEvent);

//            if(!ValidationOfUserInputData.validateMetersOrSecondsEvent(set.getString(13))){       //TODO enable after repairing original code
//                throw new RecordFormatException("Invalid ThousandFiveHundredMetersEvent data");
//            }
            ThousandFiveHundredMetersEvent thousandFiveHundredMetersEvent = new ThousandFiveHundredMetersEvent(set.getDouble(13));
            participantResults.add(thousandFiveHundredMetersEvent);

            Participant participant = new Participant(name, birthDate, countryCode);

            return new Record(participant, participantResults);

        }
        return null;
    }
}
