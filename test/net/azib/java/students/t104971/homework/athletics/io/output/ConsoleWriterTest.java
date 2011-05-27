package net.azib.java.students.t104971.homework.athletics.io.output;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class ConsoleWriterTest extends CommonOutputTestCase {
    @Test
    public void testWrite() throws Exception {
        ConsoleWriter writer = new ConsoleWriter(getTestAthletes());
        String storedLine = writer.write(null);
        assertEquals("Athlete{ place=1, totalScore=0, name= Jaak Tepandi, country= EE, dateBirth=01.01.1976}\n" +
                "\t\tResult{type=RACE_100_METERS, result=5.0, score=2640}\n" +
                "\t\tResult{type=LONG_JUMP, result=5.0, score=382}\n" +
                "\t\tResult{type=SHOT_PUT, result=5.0, score=191}\n" +
                "\t\tResult{type=HIGH_JUMP, result=5.0, score=4570}\n" +
                "\t\tResult{type=RACE_400_METERS, result=5.0, score=3994}\n" +
                "\t\tResult{type=RACE_110_METERS_HURDLES, result=5.0, score=2463}\n" +
                "\t\tResult{type=DISCUS_THROW, result=5.0, score=12}\n" +
                "\t\tResult{type=POLE_VAULT, result=5.0, score=910}\n" +
                "\t\tResult{type=JAVELIN_THROW, result=5.0, score=0}\n" +
                "\t\tResult{type=RACE_1500_METERS, result=5.0, score=3372}", storedLine);
    }
}
