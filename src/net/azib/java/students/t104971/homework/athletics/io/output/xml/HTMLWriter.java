package net.azib.java.students.t104971.homework.athletics.io.output.xml;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class HTMLWriter extends XMLWriter {

    private static String outputFileHTML = outputFileXML.replace(".xml", ".html");

    public HTMLWriter(List<Athlete> athletes) {
        super(athletes);
    }

    @Override
    public Transformer getTransformer() throws TransformerConfigurationException {
        return TransformerFactory.newInstance().newTransformer(new StreamSource(xslFile));
    }

    @Override
    public void setOutputFileName(String outputFileName) {
        super.outputFileName = outputFileName.isEmpty() ? outputFileHTML : outputFileName;
    }
}
