package net.azib.java.students.t103640.homework;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataToXMLWriter {

	/**
	 *  This method creates a XML file and outputs given data there. It also validates the XML file.
	 * @param athletes the data that has been given for outputting
	 * @param outputParam the filename or path of xml file
	 */
    public void writeDataToXml(ArrayList<Athlete> athletes, String outputParam) {
        String filePath = new CustomUtilities().getAbsolutePath(outputParam);

        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            doc = createDocument(doc, athletes);

            outputXML(doc, filePath);

        } catch (ParserConfigurationException e) {
            System.out.println("Some problems occurred while outputting results to XML");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void outputXML(Document document, String filePath) throws TransformerException {

        File file = new File(filePath);

        Transformer trans = TransformerFactory.newInstance().newTransformer();

        trans.setOutputProperty(OutputKeys.METHOD, "xml");
        trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, getClass().getResource("XMLValidation.dtd").getPath());

       trans.transform(new DOMSource(document), new StreamResult(file));

    }

    protected Document createDocument(Document doc, ArrayList<Athlete> athletesSource) {
        Element athletes = doc.createElement("Athletes");
        doc.appendChild(athletes);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


        for (Athlete athleteFromSource : athletesSource) {
            Element athlete = doc.createElement("Athlete");
            athletes.appendChild(athlete);

            Element place = doc.createElement("Place");
            athlete.appendChild(place);
            place.appendChild(doc.createTextNode(athleteFromSource.getPlace()));

            Element name = doc.createElement("Name");
            athlete.appendChild(name);
            name.appendChild(doc.createTextNode(athleteFromSource.getName()));

            Element score = doc.createElement("Score");
            athlete.appendChild(score);
            score.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getScore())));

            Element bday = doc.createElement("BirthDay");
            athlete.appendChild(bday);
            bday.appendChild(doc.createTextNode(dateFormat.format(athleteFromSource.getBirthday())));

            Element country = doc.createElement("Country");
            athlete.appendChild(country);
            country.appendChild(doc.createTextNode(athleteFromSource.getCountry()));

            Element  hundMet = doc.createElement("HundredMeterSprint");
            athlete.appendChild(hundMet);
            hundMet.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getHundredMSprint())));

            Element lj = doc.createElement("LongJump");
            athlete.appendChild(lj);
            lj.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getLongJump())));

            Element sp = doc.createElement("ShotPut");
            athlete.appendChild(sp);
            sp.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getShotPut())));

            Element hj = doc.createElement("HighJump");
            athlete.appendChild(hj);
            hj.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getHighJump())));

            Element fourHm= doc.createElement("FourHundredMeterRace");
            athlete.appendChild(fourHm);
            fourHm.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getFourHundredMSprint())));

            Element hhm = doc.createElement("HTMHurdles");
            athlete.appendChild(hhm);
            hhm.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getHundredAndTenHurdles())));

            Element disc = doc.createElement("DiscusThrow");
            athlete.appendChild(disc);
            disc.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getDiscusThrow())));

            Element pole = doc.createElement("PoleVault");
            athlete.appendChild(pole);
            pole.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getPoleVault())));

            Element javelin = doc.createElement("JavelinThrow");
            athlete.appendChild(javelin);
            javelin.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getJavelinThrow())));

            Element kilometerPlusHalf = doc.createElement("KndHRace");
            athlete.appendChild(kilometerPlusHalf);
            kilometerPlusHalf.appendChild(doc.createTextNode(Double.toString(athleteFromSource.getKilometerAndHalfRace())));

        }
        return doc;
    }
}
