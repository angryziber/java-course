package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.DecathlonException;
import net.azib.java.students.t073756.homework.beans.Athlete;
import net.azib.java.students.t073756.homework.beans.Result;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class XmlOutput extends AbstractFileOutput {

    private Document doc;

    public XmlOutput(File outputFile) {
        super(outputFile);
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            throw new DecathlonException("unable to create xml document");
        }
    }

    public void writeAthletes(List<Athlete> athletes) {
        Element root = doc.createElement("Decathlon");
        doc.appendChild(root);
        for (Athlete a : athletes) {
            Result result = a.getResult();
            Element athleteElement = doc.createElement("athlete");
            appendNodeWithText(athleteElement, "place", result.getPlace().toString());
            appendNodeWithText(athleteElement, "overall_result", Integer.toString(result.getOverallResult()));
            appendNodeWithText(athleteElement, "name", a.getName());
            appendNodeWithText(athleteElement, "birthday", new SimpleDateFormat("dd.MM.yyyy").format(a.getDateOfBirth()));
            appendNodeWithText(athleteElement, "country", a.getCountry());
            for (Map.Entry<DecathlonEvent, String> resultEntries : result.getResults().entrySet()) {
                appendNodeWithText(athleteElement, resultEntries.getKey().name(), resultEntries.getValue());
            }

            root.appendChild(athleteElement);
        }

        createOutput();
    }

    void createOutput() {
        writeToFile(transformToString());
    }

    private void appendNodeWithText(Element root, String nodeName, String text) {
        Element childElement = doc.createElement(nodeName);
        childElement.appendChild(doc.createTextNode(text));
        root.appendChild(childElement);
    }

    private String transformToString() {
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            t.transform(source, result);
            return  sw.toString();
        } catch (TransformerException e) {
            throw new DecathlonException("unable to transform xml document to string");
        }
    }

    public Document getDocument() {
        return doc;
    }
}
