package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import org.custommonkey.xmlunit.Validator;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLValid;
import org.xml.sax.SAXException;

import java.io.InputStreamReader;

import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 15.05.2008
 * <br>Time: 22:15:22
 */
public class DecathlonResultsTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void testValid() throws SAXException {
        InputStreamReader xmlReader = new InputStreamReader(getClass().getResourceAsStream("decathlonResults.xml"));
        String xsdPath = getClass().getResource("decathlonResults.xsd").getPath();

        Validator validator = new Validator(xmlReader, xsdPath);
        validator.useXMLSchema(true);
        assertXMLValid(validator);
    }
}
