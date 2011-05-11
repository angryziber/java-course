package net.azib.java.students.t104971.homework.athletics.util;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static net.azib.java.students.t104971.homework.athletics.util.PlaceHolderUtil.getPlace;

/**
 * @author Jaroslav Judin
 */
public class PlaceHolderUtilTest {

    @Test
    public void testGetRangeOfPlaces() throws Exception {
        Athlete athlete = createAthlete(100);
        List<Athlete> athletes = new ArrayList<Athlete>();
        athletes.add(createAthlete(80));
        athletes.add(createAthlete(100));
        athletes.add(athlete);
        athletes.add(createAthlete(100));
        Collections.sort(athletes);

        assertEquals("1-3", getPlace(athlete, athletes));

    }

    @Test
    public void testGetUniquePlace() throws Exception {
        Athlete athlete = createAthlete(100);
        List<Athlete> athletes = new ArrayList<Athlete>();
        athletes.add(createAthlete(80));
        athletes.add(createAthlete(70));
        athletes.add(athlete);
        athletes.add(createAthlete(110));
        Collections.sort(athletes);

        assertEquals("2", getPlace(athlete, athletes));

    }


    private Athlete createAthlete(int score){
        Athlete athlete = new Athlete();
        athlete.setTotalScore(score);
        return athlete;
    }
}
