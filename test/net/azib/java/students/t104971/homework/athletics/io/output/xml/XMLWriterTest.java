package net.azib.java.students.t104971.homework.athletics.io.output.xml;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.io.TestDB;
import net.azib.java.students.t104971.homework.athletics.io.output.CommonOutputTest;
import net.azib.java.students.t104971.homework.athletics.io.output.OutputWriter;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class XMLWriterTest extends CommonOutputTest {

    @Test
    public void testWrite() throws Exception {
        OutputWriter xmlWriter = new XMLWriter(TestDB.getTestAthletes());

        String content = readCreatedFile(xmlWriter.write("tmpXmlFile.xml"));

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<?xml-stylesheet type=\"text/xsl\" href=\"" + PropertiesLoader.getPagePath() + "\"?>\n" +
                "\n" +
                "<decathlon>\n" +
                "<sportsman>\n" +
                "<name>Jaak Tepandi</name>\n" +
                "<place>1</place>\n" +
                "<totalscore>0</totalscore>\n" +
                "<participation>\n" +
                "<event name=\"RACE_100_METERS\">\n" +
                "<points unit=\"seconds\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"LONG_JUMP\">\n" +
                "<points unit=\"meters\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"SHOT_PUT\">\n" +
                "<points unit=\"meters\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"HIGH_JUMP\">\n" +
                "<points unit=\"meters\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"RACE_400_METERS\">\n" +
                "<points unit=\"seconds\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"RACE_110_METERS_HURDLES\">\n" +
                "<points unit=\"seconds\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"DISCUS_THROW\">\n" +
                "<points unit=\"meters\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"POLE_VAULT\">\n" +
                "<points unit=\"meters\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"JAVELIN_THROW\">\n" +
                "<points unit=\"meters\">5.0</points>\n" +
                "</event>\n" +
                "<event name=\"RACE_1500_METERS\">\n" +
                "<points unit=\"seconds\">5.0</points>\n" +
                "</event>\n" +
                "</participation>\n" +
                "</sportsman>\n" +
                "</decathlon>\n", content);

    }
}
