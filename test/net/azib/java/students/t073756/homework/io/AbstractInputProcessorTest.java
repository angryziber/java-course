package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.beans.Athlete;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static net.azib.java.students.t073756.homework.DecathlonEvent.*;

/**
 * User: anton
 * Date: 4/11/11
 * Time: 11:05 PM
 */
public class AbstractInputProcessorTest {

    AbstractInputProcessor processor = new AbstractInputProcessor<Object>(new Object()) {
        public List<Athlete> readAthletes() {
            return null;
        }
    };

    @Test
    public void shouldCreateAthlete() throws Exception {
        List<String> athleteData =
                Arrays.asList("Siim Susi", "01.01.1976", "EE", "12.61", "5.00", "9.22", "1.50", "59.39", "16.43", "21.60", "2.60", "35.81", "5:25.72");

        Athlete a = processor.createAthlete(athleteData);

        Iterator<String> i = athleteData.iterator();
        assertEquals(i.next(), a.getName());
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse(i.next()), a.getDateOfBirth());
        assertEquals(i.next(), a.getCountry());

        Map<DecathlonEvent,String> results = a.getResult().getResults();
        assertEquals(i.next(), results.get(M_100));
        assertEquals(i.next(), results.get(LONG_JUMP));
        assertEquals(i.next(), results.get(SHOT_PUT));
        assertEquals(i.next(), results.get(HIGH_JUMP));
        assertEquals(i.next(), results.get(M_400));
        assertEquals(i.next(), results.get(HURDLES_110));
        assertEquals(i.next(), results.get(DISCUS_THROW));
        assertEquals(i.next(), results.get(POLE_VAULT));
        assertEquals(i.next(), results.get(JAVELIN_THROW));
        assertEquals(i.next(), results.get(M_1500));
    }
}
