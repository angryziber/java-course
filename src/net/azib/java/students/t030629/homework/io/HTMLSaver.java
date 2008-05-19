package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.utils.QuietCloser;
import net.azib.java.students.t030629.homework.utils.LoggingException;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.logging.Logger;


/**
 * Saves the statistics of the Decathlon competition into a HTML file.
 * First, the statistics is saved to a temporary XML file.
 * Then the XML file is transform to the HTML file using the default XSL
 * ({@link #DEFAULT_XSL_PATH}).
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 16.05.2008
 * <br>Time: 11:12:23
 */
public class HTMLSaver implements AthleteSaver {
    private static final Logger LOG = Logger.getLogger(HTMLSaver.class.getName());

    private final File htmlFile;
    private static final String DEFAULT_XSL_PATH = "decathlonResults.xsl";

    /**
     * Constructor
     * @param htmlFile to save the decathlon statistics to
     */
    public HTMLSaver(File htmlFile) {
        this.htmlFile = htmlFile;
    }

    /** {@inheritDoc} */
    public void save(OrderedAthlete... athlets) {
        String htmlName = htmlFile.getName();
        File xmlFile = null;
        InputStream xsltStream = null;
        InputStream xmlStream = null;
        OutputStreamWriter out = null;

        try {
            /* Create temporary XML file */
            xmlFile = File.createTempFile(htmlName.substring(0, htmlName.lastIndexOf(".")), ".xml");
            new XMLSaver(xmlFile).save(athlets);

            /* Transform XML into HTML */
            xsltStream = getClass().getResourceAsStream(DEFAULT_XSL_PATH);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsltStream));

            xmlStream = new FileInputStream(xmlFile);
            out = new OutputStreamWriter(new FileOutputStream(htmlFile), System.getProperty(DecathlonCalculator.ENCODING_KEY));
            StreamResult result = new StreamResult(out);
            transformer.setParameter(OutputKeys.INDENT, "yes");
            transformer.transform(new StreamSource(xmlStream), result);
            transformer.reset();

        } catch (Exception e) {
            throw new LoggingException(ERROR_SAVING_MESSAGE + e.getMessage(), LOG);
        } finally {
            QuietCloser.closeSilently(xsltStream, LOG);
            QuietCloser.closeSilently(xmlStream, LOG);
            QuietCloser.closeSilently(out, LOG);            
            if (xmlFile != null) {
                xmlFile.delete();
            }
        }

    }
}
