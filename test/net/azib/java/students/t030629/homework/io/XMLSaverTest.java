package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import org.junit.Before;
import org.w3c.dom.Document;
import static org.custommonkey.xmlunit.XMLAssert.*;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.utils.OrderedAthleteWrapper;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Arrays;


/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 15.05.2008
 * <br>Time: 13:41:15
 */
public class XMLSaverTest {
    private OrderedAthlete orderedAthlete;
    private OrderedAthlete[] orderedAthletes;

    static {
        DecathlonCalculator.initProperties();
    }

    @Before
    public void createOrderedAthletes() throws ParserConfigurationException {
        Athlete[] athletes = AthleteCreatorTestHelper.createAthletes(0, 1);
        this.orderedAthlete = new OrderedAthleteWrapper().wrap(athletes[0])[0];
        DecathlonCalculator.sortAthletesByResult(Arrays.asList(athletes));
        this.orderedAthletes = new OrderedAthleteWrapper().wrap(athletes);

    }

    @Test
    public void testXPath() throws ParserConfigurationException, XpathException, IOException, SAXException, URISyntaxException {
        Document createdDocument = new XMLSaver(null).createDocument(orderedAthlete);

        assertXpathEvaluatesTo("3100", "//results/@total_score", createdDocument);
    }

    @Test
    public void testValid() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = null;

        try {
            /* Write to temp dir */
            xmlFile = File.createTempFile("decathlonCreated", ".xml");
            new XMLSaver(xmlFile).save(orderedAthlete);

            /* XML source and XSD for validation */
            InputSource inputSource = new InputSource(new InputStreamReader(new FileInputStream(xmlFile), System.getProperty(DecathlonCalculator.ENCODING_KEY)));
            String xsdPath = getClass().getResource("decathlonResults.xsd").getPath();

            /* Validate */
            Validator validator = new Validator(inputSource, xsdPath);
            validator.useXMLSchema(true);
            assertXMLValid(validator);

        } finally {
            if (xmlFile != null) {
                xmlFile.delete();
            }
        }

    }

//    @Test
//    public void testEquals() throws IOException, SAXException, ParserConfigurationException {
//        Document correctDocument = XMLUnit.buildControlDocument(new InputSource(getClass().getResourceAsStream("decathlonResults.xml")));
//        Document createdDocument = new XMLSaver(null).createDocument(orderedAthletes);
//
//        XMLUnit.setIgnoreWhitespace(true);
//        assertXMLEqual(correctDocument, createdDocument);
//    }


}
