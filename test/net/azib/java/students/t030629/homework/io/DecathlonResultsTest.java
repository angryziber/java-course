package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import org.custommonkey.xmlunit.Validator;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLValid;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import net.azib.java.students.t030629.homework.DecathlonCalculator;

import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Source;

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
        InputSource xmlSource = new InputSource(getClass().getResourceAsStream("decathlonResults.xml"));
        String xsdPath = getClass().getResource(XMLSaver.DEFAULT_XSD_PATH).getPath();

        Validator validator = new Validator(xmlSource, xsdPath);
        validator.useXMLSchema(true);
        assertXMLValid(validator);
    }
}
