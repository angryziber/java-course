package net.azib.java.students.t030632.homework;

import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
 *
 * @author Toni
 */
public class XmlCreator {
	
	/**
	 * Creates xml File from sorted competitors list
	 * @param xmlFile
	 * @param competitorsList
	 */
	public XmlCreator(File xmlFile, List<Competitor> competitorsList){
		try {
            Document doc = null;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = builder.newDocument();

            Element comp = doc.createElement("competition");
            doc.appendChild(comp);
            
            /*sorting competitors by place achieved in competition*/
            Map<Integer, String> places = new PlaceCalculator(competitorsList).getPlaces();
            
            Set <String> sortingCompetitors = new TreeSet<String>();
            for(Competitor champ:competitorsList){
            	sortingCompetitors.add(champ.getPoints()+places.get(champ.getPoints())+"|"+champ.getInitialData());
            }
            List <String> sortingCompetitorsArray = new ArrayList<String>();
            for(String data : sortingCompetitors){
            	sortingCompetitorsArray.add(data);
            }
            List <Competitor> sortedCompetitorsList = new LinkedList<Competitor>();
            for(int i= sortingCompetitorsArray.size()-1; i>-1; i--){
            	sortedCompetitorsList.add(new Competitor(sortingCompetitorsArray.get(i).substring(sortingCompetitorsArray.get(i).indexOf("|")+1)));
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);
            int man=0;// id of competitor
            for(Competitor champ:sortedCompetitorsList){
            /*for (int man = 0; man < pointsArray.length; man++) {*/
                Element comper = doc.createElement("competitor");
                comper.setAttribute("id", String.valueOf(++man));
                comp.appendChild(comper);
                
                Element comperName = doc.createElement("competitors_name");
                comperName.appendChild(doc.createTextNode(String.valueOf(champ.getName())));
                comper.appendChild(comperName);
                
                Element comperDate = doc.createElement("competitors_date_of_birth");
                DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                comperDate.appendChild(doc.createTextNode(String.valueOf(sdf.format(champ.getBirthDate()))));
                comper.appendChild(comperDate);
                
                Element comperCountry = doc.createElement("competitors_Country");
                comperCountry.appendChild(doc.createTextNode(String.valueOf(champ.getCountry().getDisplayCountry())));
                comper.appendChild(comperCountry);
                
                /*Total Points*/
                Element total = doc.createElement("Total_Points");
                total.appendChild(doc.createTextNode(String.valueOf(champ.getPoints())));
                comper.appendChild(total);

                /*Place*/
                Element place = doc.createElement("place");
                place.appendChild(doc.createTextNode(String.valueOf(places.get(champ.getPoints()))+"."));
                comper.appendChild(place);

                
                Element events = doc.createElement("events");
                comper.appendChild(events);

                /*1. 100m sprint*/
                Element eventSprint = doc.createElement("event");
                eventSprint.setAttribute("name", "100 m sprint");
                events.appendChild(eventSprint);
                
                Element resultSprint = doc.createElement("result");
                resultSprint.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getSprint())+" sec")));
                eventSprint.appendChild(resultSprint);
                
                /*2. Long Jump*/
                Element eventLongJump = doc.createElement("event");
                eventLongJump.setAttribute("name", "Long Jump");
                events.appendChild(eventLongJump);
                
                Element resultLongJump = doc.createElement("result");
                resultLongJump.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getLongJump())+" m")));
                eventLongJump.appendChild(resultLongJump);
                
                /*3. Shot Put*/
                Element eventShotPut = doc.createElement("event");
                eventShotPut.setAttribute("name", "Shot Put");
                events.appendChild(eventShotPut);
                
                Element resultShotPut = doc.createElement("result");
                resultShotPut.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getShotPut())+" m")));
                eventShotPut.appendChild(resultShotPut);
                
                /*4. High Jump*/
                Element eventHighJump = doc.createElement("event");
                eventHighJump.setAttribute("name", "High Jump");
                events.appendChild(eventHighJump);
                
                Element resultHighJump = doc.createElement("result");
                resultHighJump.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getHighJump())+" m")));
                eventHighJump.appendChild(resultHighJump);
                
                /*5. 400m Sprint */
                Element eventLongSprint = doc.createElement("event");
                eventLongSprint.setAttribute("name", "400m Sprint");
                events.appendChild(eventLongSprint);
                
                Element resultLongSprint = doc.createElement("result");
                resultLongSprint.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getLongSprint())+" sec")));
                eventLongSprint.appendChild(resultLongSprint);
                
                /*6. 110m Hurdles */
                Element eventHurdles = doc.createElement("event");
                eventHurdles.setAttribute("name", "110m Hurdles");
                events.appendChild(eventHurdles);
                
                Element resultHurdles = doc.createElement("result");
                resultHurdles.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getHurdles())+" sec")));
                eventHurdles.appendChild(resultHurdles);
                
                /*7. Discus Throw */
                Element eventDiscus = doc.createElement("event");
                eventDiscus.setAttribute("name", "Discus Throw");
                events.appendChild(eventDiscus);
                
                Element resultDiscus = doc.createElement("result");
                resultDiscus.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getDiscusThrow())+" m")));
                eventDiscus.appendChild(resultDiscus);
                
                /*8. Pole Vault */
                Element eventPole = doc.createElement("event");
                eventPole.setAttribute("name", "Pole Vault");
                events.appendChild(eventPole);
                
                Element resultPole = doc.createElement("result");
                resultPole.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getPoleVault())+" m")));
                eventPole.appendChild(resultPole);
                
                /*9. Javelin Throw */
                Element eventJavelin = doc.createElement("event");
                eventJavelin.setAttribute("name", "Javelin Throw");
                events.appendChild(eventJavelin);
                
                Element resultJavelin = doc.createElement("result");
                resultJavelin.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getJavelinThrow())+" m")));
                eventJavelin.appendChild(resultJavelin);
                
                /*10. 1500m race*/
                Element eventRace = doc.createElement("event");
                eventRace.setAttribute("name", "1500m race");
                events.appendChild(eventRace);
                
                Element resultRace = doc.createElement("result");
                resultRace.appendChild(doc.createTextNode(String.valueOf(nf.format(champ.getRace())+" sec")));
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
                System.err.println("Error: " + e);
                System.exit(1);
            }
        }
        catch (Exception e) {
            System.err.print("Error: " + e);
            System.exit(1);
        }
        System.out.println("XML done!");
		
	}
	/**
	 * perfomrs xml data transformation to the specified html file (using defined style from xslt file)
	 * @param xmlFile xml file
	 * @param xsltFile xst Transformation file
	 * @param htmlFile html file
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
            System.err.print("Exception: "+e);
        }
        System.out.println("HTML done!");
    }

}
