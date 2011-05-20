package net.azib.java.students.t110013.homework.writers;

import net.azib.java.students.t110013.homework.model.Athlete;
import org.jdom.output.DOMOutputter;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

import static org.apache.commons.io.IOUtils.closeQuietly;

/**
 * //TODO class description
 * @author Vadim
 */
public class HTMLAthletesWriter extends XMLAthletesWriter implements AthletesWriter {
    private static final String UTF8_CHARSET = "UTF-8";
    private static final String XSL_FILE = "decathlon.xsl";
    private static final Logger LOG = Logger.getLogger(HTMLAthletesWriter.class.getName());
    private String filename;

    HTMLAthletesWriter(String filename) {
        super(filename);
        this.filename = filename;
    }

	/**
	 * //TODO method description
	 * @param athletes A
	 */
    @Override
    public void writeAthletes(List<Athlete> athletes) {
        writeHTML(filename, athletes);
    }

    void writeHTML(String filename, List<Athlete> athletes) {
        InputStream input = null;
        PrintWriter writer = null;

        try {
            Document document = new DOMOutputter().output(validateXMLDocument(buildXMLDocument(athletes)));

            input = validateResourceStream(HTMLAthletesWriter.class.getResourceAsStream(XSL_FILE), XSL_FILE);
            writer = new PrintWriter(new File(filename), UTF8_CHARSET);

            Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(input));
            transformer.transform(new DOMSource(document), new StreamResult(writer));
        }
        catch (FileNotFoundException e) {
            LOG.severe("The specified HTML file name " + filename + " is invalid.\n");
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            if (input != null) closeQuietly(input);
            if (writer != null) writer.close();
        }
    }
}
