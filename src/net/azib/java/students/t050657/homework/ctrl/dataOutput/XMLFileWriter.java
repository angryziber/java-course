package net.azib.java.students.t050657.homework.ctrl.dataOutput;

import net.azib.java.students.t050657.homework.model.Athlet;
import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.model.Result;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.ProcessingInstruction;
import org.jdom.output.XMLOutputter;

/**
 * XMLFileWriter
 *
 * @author Boriss
 */
public class XMLFileWriter implements DataWriter{

	private Document doc;
	/**
	 * By default so. Can be changed with setter.
	 */
	private String stylecheet = "type=\"text/xsl\" href=\"competition.xsl\"";
	
	/**
	 * Writes competition to XML file using DOM.
	 * For style cheet sets competition.xsl file.
	 */
	public void writeCompetition(Competition competition) throws IOException {
		doc = new Document();
		
		Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		Namespace xsd =  Namespace.getNamespace("noNamespaceSchemaLocation", "competition.xsd");
		
		ProcessingInstruction pi = new ProcessingInstruction("xml-stylesheet", stylecheet);
		doc.addContent(pi);
		
		Element root = new Element("competitions");
		
		doc.addContent(root);
		
		root.addNamespaceDeclaration(xsi);
		root.addNamespaceDeclaration(xsd);
		
		this.addCompetition(competition);
		
		for(Result result : competition.getResults()) {
			this.addAthletToCompetition(result.getAthlet(), competition);
			try {
				this.addResultToAthlet(result, competition);
			}catch (InsufficientResultsException e) {
				System.out.println("In " + competition + ", " + result.getAthlet() + " has not all results inserted");
			}
		}
		
		if(competition.getDescription() == null) {
			competition.setDescription("Competition");
		}
		
		this.writeXMLtoFile(path + competition.getDescription() + ".xml");
	}
	
	private void addCompetition(Competition competition) {
		Element comp = new Element("competition");
		
		if(competition.getEventDate() != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Attribute dateAttr = new Attribute("date", df.format(competition.getEventDate().getTime()));
			comp.setAttribute(dateAttr);
		}
		if(competition.getCountryCode() != null) {
			Attribute countryCodeAttr = new Attribute("countryCode", competition.getCountryCode());
			comp.setAttribute(countryCodeAttr);
		}
		if(competition.getDescription() != null) {
			Attribute descriptionAttr = new Attribute("description", competition.getDescription());
			comp.setAttribute(descriptionAttr);
		}
		
		doc.getRootElement().addContent(comp);
	}
	
	private boolean addAthletToCompetition(Athlet athlet, Competition competition) {
		Element comp = (Element)doc.getRootElement().getChildren().get(0);
		
		if(comp == null)
			return false;
		
		Element ath = new Element("athlet");
		
		if(athlet.getName() != null) {
			Attribute nameAttr = new Attribute("name", athlet.getName());
			ath.setAttribute(nameAttr);
		}
		if(athlet.getDateOfBirth() != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Attribute dateAttr = new Attribute("date", df.format(athlet.getDateOfBirth().getTime()));
			ath.setAttribute(dateAttr);
		}
		if(athlet.getCountryCode() != null) {
			Attribute countryCodeAttr = new Attribute("countryCode", athlet.getCountryCode());
			ath.setAttribute(countryCodeAttr);
		}
		
		comp.addContent(ath);
		
		return true;
	}
	
	private void addResultToAthlet(Result result, Competition competition) 
						throws InsufficientResultsException{
		Element comp = (Element)doc.getRootElement().getChildren().get(0);
		Element ath = this.findAthlet(result.getAthlet(), comp);
		
		if (result.getPlace() != null) {
			Element place = new Element("place");
			place.setText(result.getPlace());
			ath.addContent(place);
		}		
		if (result.getFinalScore() != 0) {
			Element finalScore = new Element("finalscore");
			finalScore.setText(result.getFinalScore() + "");
			ath.addContent(finalScore);
		}
		
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			Element event = new Element("event");
			Attribute titleAttr = new Attribute("title", decCoef.getTitle());
			event.setAttribute(titleAttr);
			event.setText(Math.rint(result.getResult(decCoef)) + "");
			ath.addContent(event);
		}
	}
	
	private void writeXMLtoFile(String filename) throws IOException{		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filename), "UTF8"));
		
		XMLOutputter serializer = new XMLOutputter();
		serializer.output(doc, writer);
		writer.close();
	}
	
	private Element findAthlet(Athlet athlet, Element competition) {
		List<Element> athlets = competition.getChildren();
		for(Element a : athlets) {
			String name = a.getAttributeValue("name");
			String date = a.getAttributeValue("date");
			String country = a.getAttributeValue("countryCode");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			if(athlet.getCountryCode().equals(country) &&
					athlet.getName().equals(name) &&
					df.format(athlet.getDateOfBirth().getTime()).equals(date)) {
				return a;
			}
		}
		return null;
	}

	public String getStylecheet() {
		return stylecheet;
	}

	public void setStylecheet(String stylecheet) {
		this.stylecheet = stylecheet;
	}

}
