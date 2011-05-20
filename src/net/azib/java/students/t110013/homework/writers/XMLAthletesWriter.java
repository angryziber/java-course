package net.azib.java.students.t110013.homework.writers;

import net.azib.java.students.t110013.homework.model.Athlete;
import net.azib.java.students.t110013.homework.model.Decathlon;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.DOMOutputter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.List;
import java.util.logging.Logger;

import static org.apache.commons.io.IOUtils.closeQuietly;

/**
 * @author Vadim
 */
public class XMLAthletesWriter implements AthletesWriter {
    private static final String UTF8_CHARSET = "UTF-8";
    private static final String XSD_FILE = "decathlon.xsd";
    private static final Logger LOG = Logger.getLogger(XMLAthletesWriter.class.getName());
    private String filename;

    XMLAthletesWriter(String filename) {
        this.filename = filename;
    }

	@Override
    public void writeAthletes(List<Athlete> athletes) {
        writeXML(filename, athletes);
    }

    void writeXML(String filename, List<Athlete> athletes) {
        Document decathlonXML = validateXMLDocument(buildXMLDocument(athletes));
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new File(filename), UTF8_CHARSET);

            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.setFormat(Format.getPrettyFormat());
            xmlOutputter.output(decathlonXML, writer);
        }
        catch (FileNotFoundException e) {
            LOG.severe("The specified XML file name " + filename + " is invalid.\n");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) writer.close();
        }
    }

    Document buildXMLDocument(List<Athlete> athletes) {
        Element decathlon = new Element("decathlon");

        for (Athlete a : athletes) {
            Element athlete = new Element("athlete");
            Element events = new Element("events");

            athlete.addContent(new Element("name").setText(a.getName()));
            athlete.addContent(new Element("born").setText(a.getDateOfBirth()));
            athlete.addContent(new Element("country").setText(a.getCountry()));
            athlete.addContent(new Element("place").setText(a.getPlace()));
            athlete.addContent(new Element("points").setText(String.valueOf(a.getTotalScore())));

            for (Decathlon e : Decathlon.values()) {
                Element event = new Element("event");

                event.addContent(new Element("name").setText(e.getName()));
                event.addContent(new Element("result").setText(String.valueOf(a.getPerformanceResult(e.getIndex()))));
                events.addContent(event);
            }

            athlete.addContent(events);
            decathlon.addContent(athlete);
        }

        return new Document(decathlon);
    }

    Document validateXMLDocument(Document document) {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        InputStream input = null;

        try {
            input = validateResourceStream(XMLAthletesWriter.class.getResourceAsStream(XSD_FILE), XSD_FILE);

            Source schemaFile = new StreamSource(input);
            Schema schema = factory.newSchema(schemaFile);

            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(new DOMOutputter().output(document)));
        }
        catch (SAXException e) {
            LOG.warning("Failed to validate the built XML document.\n" + e.getMessage() + "\n");
            return document;
        }
        catch (JDOMException e) {
            LOG.warning(e.getMessage());
            return document;
        }
        catch (IOException e) {
            LOG.warning(e.getMessage());
            return document;
        }
        finally {
            if (input != null) closeQuietly(input);
        }

        return document;
    }

    InputStream validateResourceStream(InputStream input, String filename) {
        if (input == null) {
            LOG.severe("The file " + filename + " cannot be found. Verify that it exists.\n");
            throw new RuntimeException();
        }
	    else
	        return input;
    }
}
