package net.azib.java.students.t104971.homework.athletics.io.output.xml;

import net.azib.java.students.t104971.homework.athletics.components.Athlete;
import net.azib.java.students.t104971.homework.athletics.components.Result;
import net.azib.java.students.t104971.homework.athletics.util.PlaceHolderUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class XMLBuilder {

    public static Document constructXML(String xslFile, List<Athlete> athletes) {

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


            for (Athlete man : athletes) {
                //create child element, add an attribute, and add to root
                sportsman = doc.createElement("sportsman");
                name = doc.createElement("name");
                name.appendChild(doc.createTextNode(man.getName()));
                sportsman.appendChild(name);

                place = doc.createElement("place");

                place.appendChild(doc.createTextNode(PlaceHolderUtil.getPlace(man, athletes)));
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
}
