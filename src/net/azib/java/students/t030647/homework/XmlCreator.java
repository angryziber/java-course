package net.azib.java.students.t030647.homework;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XmlCreator
 * Creates xml file from competition's data
 * @author Igor
 */
public class XmlCreator {
	
	/**
	 * 
	 * @param xmlFile
	 * @param data
	 */
	public XmlCreator(File xmlFile, String[] data){
		try {
            Document doc = null;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.newDocument();

            Element comp = doc.createElement("competition");
            doc.appendChild(comp);
            
            int id=0;// id of competitor
            for (int i=0; i<data.length; i++) {
            	String[] d = data[i].split(",");
            	
            	Element comper = doc.createElement("Participant");
                comper.setAttribute("id", String.valueOf(++id));
                comp.appendChild(comper);
                
                Element comperName = doc.createElement("Name");
                comperName.appendChild(doc.createTextNode(d[2]));
                comper.appendChild(comperName);
                
                Element comperDate = doc.createElement("Birthday");
                comperDate.appendChild(doc.createTextNode(d[3]));
                comper.appendChild(comperDate);
                
                Element comperCountry = doc.createElement("Country");
                comperCountry.appendChild(doc.createTextNode(String.valueOf(d[4])));
                comper.appendChild(comperCountry);
                
                /*Total Points*/
                Element total = doc.createElement("Total_Points");
                total.appendChild(doc.createTextNode(String.valueOf(d[1])));
                comper.appendChild(total);

                /*Place*/
                Element place = doc.createElement("Place");
                place.appendChild(doc.createTextNode(d[0]));
                comper.appendChild(place);

                
                Element events = doc.createElement("Events");
                comper.appendChild(events);

                /*1. 100m sprint*/
                Element eventSprint = doc.createElement("event");
                eventSprint.setAttribute("name", "100 m sprint");
                events.appendChild(eventSprint);
                
                Element resultSprint = doc.createElement("result");
                resultSprint.appendChild(doc.createTextNode(d[5]));
                eventSprint.appendChild(resultSprint);
                
                /*2. Long Jump*/
                Element eventLongJump = doc.createElement("event");
                eventLongJump.setAttribute("name", "Long Jump");
                events.appendChild(eventLongJump);
                
                Element resultLongJump = doc.createElement("result");
                resultLongJump.appendChild(doc.createTextNode(d[6]));
                eventLongJump.appendChild(resultLongJump);
                
                /*3. Shot Put*/
                Element eventShotPut = doc.createElement("event");
                eventShotPut.setAttribute("name", "Shot Put");
                events.appendChild(eventShotPut);
                
                Element resultShotPut = doc.createElement("result");
                resultShotPut.appendChild(doc.createTextNode(d[7]));
                eventShotPut.appendChild(resultShotPut);
                
                /*4. High Jump*/
                Element eventHighJump = doc.createElement("event");
                eventHighJump.setAttribute("name", "High Jump");
                events.appendChild(eventHighJump);
                
                Element resultHighJump = doc.createElement("result");
                resultHighJump.appendChild(doc.createTextNode(d[8]));
                eventHighJump.appendChild(resultHighJump);
                
                /*5. 400m Sprint */
                Element eventLongSprint = doc.createElement("event");
                eventLongSprint.setAttribute("name", "400m Sprint");
                events.appendChild(eventLongSprint);
                
                Element resultLongSprint = doc.createElement("result");
                resultLongSprint.appendChild(doc.createTextNode(d[9]));
                eventLongSprint.appendChild(resultLongSprint);
                
                /*6. 110m Hurdles */
                Element eventHurdles = doc.createElement("event");
                eventHurdles.setAttribute("name", "110m Hurdles");
                events.appendChild(eventHurdles);
                
                Element resultHurdles = doc.createElement("result");
                resultHurdles.appendChild(doc.createTextNode(d[10]));
                eventHurdles.appendChild(resultHurdles);
                
                /*7. Discus Throw */
                Element eventDiscus = doc.createElement("event");
                eventDiscus.setAttribute("name", "Discus Throw");
                events.appendChild(eventDiscus);
                
                Element resultDiscus = doc.createElement("result");
                resultDiscus.appendChild(doc.createTextNode(d[11]));
                eventDiscus.appendChild(resultDiscus);
                
                /*8. Pole Vault */
                Element eventPole = doc.createElement("event");
                eventPole.setAttribute("name", "Pole Vault");
                events.appendChild(eventPole);
                
                Element resultPole = doc.createElement("result");
                resultPole.appendChild(doc.createTextNode(d[12]));
                eventPole.appendChild(resultPole);
                
                /*9. Javelin Throw */
                Element eventJavelin = doc.createElement("event");
                eventJavelin.setAttribute("name", "Javelin Throw");
                events.appendChild(eventJavelin);
                
                Element resultJavelin = doc.createElement("result");
                resultJavelin.appendChild(doc.createTextNode(d[13]));
                eventJavelin.appendChild(resultJavelin);
                
                /*10. 1500m race*/
                Element eventRace = doc.createElement("event");
                eventRace.setAttribute("name", "1500m race");
                events.appendChild(eventRace);
                
                Element resultRace = doc.createElement("result");
                resultRace.appendChild(doc.createTextNode(d[14]));
                eventRace.appendChild(resultRace);
                
            }
            try { // writing to file
                Result xmlResultStream = new StreamResult(xmlFile);
                Source source = new DOMSource(doc);
                Transformer xmlFormer = TransformerFactory.newInstance().newTransformer();
                xmlFormer.setOutputProperty(OutputKeys.INDENT, "yes");
                xmlFormer.transform(source, xmlResultStream);
            }
            catch (TransformerConfigurationException e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
                System.exit(1);
            }
        }
        catch (Exception e) {
            System.out.print("Error: " + e);
            e.printStackTrace();
            System.exit(1);
        }
		
	}
	/**
	 * Creates html file from xml file according to xsl description
	 * @param xmlFile
	 * @param xsltFile
	 * @param htmlFile
	 */
	public void CreateHTML(File xmlFile, File xsltFile, File htmlFile) {
        try {
            Result htmlResultStream = new StreamResult(htmlFile);
            Source xmlSource = new StreamSource(xmlFile);
            Source xsltSource = new StreamSource(xsltFile);
            Transformer htmlFormer = TransformerFactory.newInstance().newTransformer(xsltSource);
            htmlFormer.transform(xmlSource, htmlResultStream);
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
