/**
 *
 */
package net.azib.java.students.t104971.homework.athletics.io.xml;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import net.azib.java.students.t104971.homework.athletics.dto.*;
import net.azib.java.students.t104971.homework.athletics.dto.Result;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.List;

/**
 * @author Jaroslav Judin
 *         May 27, 2010
 */
public class XMLBuilder {

    private static final String XML_VERSION = "1.0";
    private static final String XML_ENCODING = "UTF-8";

    private static final String xslFile = PropertiesLoader.getPagePath();
    private static String outputFileXML = PropertiesLoader.getXMLPath();
    private static String outputFileHTML = outputFileXML.replace(".xml", ".html");

    private List<Athlete> athletes;

    public XMLBuilder(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public String getResult(boolean isHTML) {
        writeXML(constructXML(), isHTML);
        return isHTML ? outputFileHTML : outputFileXML;
    }

    public Document constructXML() {

        Document doc = null;
        Element root, sportsman, name, place, totalScore, part, event, point;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            doc = docBuilder.newDocument();

            ProcessingInstruction pi = doc.createProcessingInstruction("xml-stylesheet",
                    "type=\"text/xsl\" href=\"" + xslFile + "\"");
            doc.appendChild(pi);
            //Creating the XML tree

            //create the root element and add it to the document
            root = doc.createElement("decathlon");
            doc.appendChild(root);


            for (int i = 0; i < athletes.size(); i++) {
                Athlete man = athletes.get(i);
                //create child element, add an attribute, and add to root
                sportsman = doc.createElement("sportsman");
                name = doc.createElement("name");
                name.appendChild(doc.createTextNode(man.getName()));
                sportsman.appendChild(name);

                place = doc.createElement("place");
                place.appendChild(doc.createTextNode(Integer.toString(i + 1)));
                sportsman.appendChild(place);

                totalScore = doc.createElement("totalscore");
                totalScore.appendChild(doc.createTextNode(Integer.toString(man.getTotalScore())));
                sportsman.appendChild(totalScore);

                part = doc.createElement("participation");


                for (Result res : man.getResults()) {
                    event = doc.createElement("event");
                    event.setAttribute("name", res.getType().name());

                    point = doc.createElement("points");

                    point.appendChild(doc.createTextNode(Double.toString(res.getResult())));
                    point.setAttribute("unit", res.getType().getUnit());

                    event.appendChild(point);
                    part.appendChild(event);
                }
                sportsman.appendChild(part);

                root.appendChild(sportsman);

            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return doc;
    }

    public void writeXML(Document doc, boolean isHTML) {
        //Output the XML
        Transformer trans = null;
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            trans = isHTML
                    ? transformerFactory.newTransformer(new StreamSource(xslFile))
                    : transformerFactory.newTransformer();

            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.setOutputProperty(OutputKeys.METHOD, "xml");
            trans.setOutputProperty(OutputKeys.ENCODING, XML_ENCODING);
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty(OutputKeys.VERSION, XML_VERSION);

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            trans.transform(source, new StreamResult(new FileOutputStream(isHTML ? outputFileHTML : outputFileXML)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
