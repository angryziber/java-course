package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.Result;
import net.azib.java.students.t030629.homework.utils.QuietCloser;
import net.azib.java.students.t030629.homework.utils.LoggingException;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.io.*;
import java.util.Locale;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Saves the statistics of the Decathlon competition into an XML file.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 15.05.2008
 * <br>Time: 13:21:02
 */
public class XMLSaver implements AthleteSaver {
    private static final Logger LOG = Logger.getLogger(XMLSaver.class.getName());

    private final File xmlFile;
    private final CSVFormatter formatter;
    private final DefaultNormalizer defaultNormalizer;
    static final String DEFAULT_XSD_PATH = "decathlonResults.xsd";

    /**
     * Constructor with the specified XML file
     * @param xmlFile XML file to save the statistics to
     */
    public XMLSaver(File xmlFile) {
        this.xmlFile = xmlFile;
        formatter = new CSVFormatter();
        defaultNormalizer = new DefaultNormalizer();
    }

    /** {@inheritDoc} */
    public void save(OrderedAthlete... athlets) {
        BufferedWriter outputStreamWriter = null;

        try {
            Document document = createDocument(athlets);

            outputStreamWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFile), System.getProperty(DecathlonCalculator.ENCODING_KEY)));
            javax.xml.transform.Result result = new StreamResult(outputStreamWriter);
            Source source = new DOMSource(document);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (Exception e) {
            throw new LoggingException(ERROR_SAVING_MESSAGE + e.getMessage(), LOG);
        } finally {
            QuietCloser.closeSilently(outputStreamWriter, LOG);
        }

    }

    /**
     * Composes a {@link org.w3c.dom.Document} out of an array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}.
     * Currently uses {@link DocumentBuilder} for this.
     * @param athlets source athletes from which to create the Document
     * @return the Document structure of the Decathlon results
     * @throws ParserConfigurationException if {@link javax.xml.parsers.DocumentBuilderFactory#newDocumentBuilder()} throws it
     */
    Document createDocument(OrderedAthlete... athlets) throws ParserConfigurationException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        /* Root Element */
        Element rootElement = document.createElement("competitors");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", DEFAULT_XSD_PATH);
        document.setXmlStandalone(true);

        /* ATHLETES */
        for (OrderedAthlete athlete : athlets) {
            /* ###################
            *     A T H L E T E
            *  ###################*/
            Element athleteElement = document.createElement("athlete");

            /* PLACE */
            Element placeElement = document.createElement("place");
            placeElement.appendChild(document.createTextNode(athlete.getPlace().toString()));
            athleteElement.appendChild(placeElement);

            /* PERSONAL DATA */
            Element personalDataElement = document.createElement("personal_data");
            // Name
            Element nameElement = document.createElement("name");
            nameElement.appendChild(document.createTextNode(athlete.getAthlete().getName()));
            // Birth
            Element birthElement = document.createElement("birth");
            birthElement.appendChild(document.createTextNode(formatter.formatBirthday(athlete.getAthlete().getBirthday())));
            // Country
            Element countryElement = document.createElement("country");
            countryElement.appendChild(document.createTextNode(athlete.getAthlete().getLocale().getDisplayCountry(Locale.US)));
            personalDataElement.appendChild(nameElement);
            personalDataElement.appendChild(birthElement);
            personalDataElement.appendChild(countryElement);
            athleteElement.appendChild(personalDataElement);

            /* RESULTS */
            Element resultsElement = document.createElement("results");
            resultsElement.setAttribute("total_score", String.valueOf(athlete.getAthlete().getResults().getTotalScore()));
            for (Result result : athlete.getAthlete().getResults().getResults()) {
                Element resultElement = document.createElement("result");
                resultElement.setAttribute("event", result.getEvent().toString());
                resultElement.setAttribute("unit", defaultNormalizer.getNormalizedUnit(result.getEvent()));
                resultElement.appendChild(document.createTextNode(formatter.formatResult(result)));
                resultsElement.appendChild(resultElement);
            }
            athleteElement.appendChild(resultsElement);

            rootElement.appendChild(athleteElement);
        }
        document.appendChild(rootElement);

        return document;
    }

}
