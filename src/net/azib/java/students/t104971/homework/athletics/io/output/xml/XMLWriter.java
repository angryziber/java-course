/**
 *
 */
package net.azib.java.students.t104971.homework.athletics.io.output.xml;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.io.output.OutputWriter;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.List;

import static net.azib.java.students.t104971.homework.athletics.io.output.xml.XMLBuilder.constructXML;

/**
 * @author Jaroslav Judin
 *         May 27, 2010
 *         Feb 27, 2011 - refactored
 */
public class XMLWriter implements OutputWriter {

    private static final String XML_VERSION = "1.0";
    private static final String XML_ENCODING = "UTF-8";

    static final String xslFile = PropertiesLoader.getPagePath();
    static String outputFileXML = PropertiesLoader.getPagePath().replace("page.xsl", "data.out.xml");

    private List<Athlete> athletes;
    String outputFileName;

    public XMLWriter(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String write(String outputFileName) {
        setOutputFileName(outputFileName);
        try {
            Transformer t = getTransformer();

            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.ENCODING, XML_ENCODING);
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.VERSION, XML_VERSION);

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(getDocument());
            t.transform(source, result);
            t.transform(source, new StreamResult(new FileOutputStream(this.outputFileName)));

        } catch (Exception e) {
            Logger.getLogger(getClass()).error(e);
        }
        return this.outputFileName;
    }

    public Transformer getTransformer() throws TransformerConfigurationException {
        return TransformerFactory.newInstance().newTransformer();
    }

    private Document getDocument() {
        return constructXML(xslFile, athletes);
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName.isEmpty() ? outputFileXML : outputFileName;
    }
}
