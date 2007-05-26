package net.azib.java.students.t050657.homework.src.ctrl.DataOutput;

import net.azib.java.students.t050657.homework.src.model.Athlet;
import net.azib.java.students.t050657.homework.src.model.Competition;
import net.azib.java.students.t050657.homework.src.model.DecathlonCoeficient;
import net.azib.java.students.t050657.homework.src.model.InsufficientResultsException;
import net.azib.java.students.t050657.homework.src.model.Result;

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
	
	public void writeCompetition(Competition competition) throws IOException {
		doc = new Document();
		
		Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		Namespace xsd =  Namespace.getNamespace("noNamespaceSchemaLocation", "competition.xsd");
		
		ProcessingInstruction pi = new ProcessingInstruction("xml-stylesheet", 
							"type=\"text/xsl\" href=\"competition.xsl\"");
		doc.addContent(pi);
		
		Element root = new Element("competitions");
		
		doc.addContent(root);
		
		root.addNamespaceDeclaration(xsi);
		root.addNamespaceDeclaration(xsd);
		
		this.addCompetition(competition);
		
		for(Athlet a : competition.getAthlets()) {
			this.addAthletToCompetition(a, competition);
			try {
				this.addResultToAthlet(a.getResult(), a, competition);
			}catch (InsufficientResultsException e) {
				System.out.println("In " + competition + ", " + a + " has not all results inserted");
			}
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
		Element comp = this.findCompetition(competition);
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
	
	private void addResultToAthlet(Result result, Athlet athlet, Competition competition) 
						throws InsufficientResultsException{
		Element comp = this.findCompetition(competition);
		Element ath = this.findAthlet(athlet, comp);
		
		if (athlet.getPlace() != null) {
			Element place = new Element("place");
			place.setText(athlet.getPlace());
			ath.addContent(place);
		}		
		if (athlet.getFinalScore() != 0) {
			Element finalScore = new Element("finalscore");
			finalScore.setText(athlet.getFinalScore() + "");
			ath.addContent(finalScore);
		}
		
		for(DecathlonCoeficient decCoef : DecathlonCoeficient.values()) {
			Element event = new Element("event");
			Attribute titleAttr = new Attribute("title", decCoef.getTitle());
			event.setAttribute(titleAttr);
			event.setText(Math.rint(result.getConvertedResult(decCoef)) + "");
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
	
	private Element findCompetition(Competition competition) {
		List<Element> competitions = doc.getRootElement().getChildren();
		for(Element compEl : competitions) {
			String date = compEl.getAttributeValue("date");
			String country = compEl.getAttributeValue("countryCode");
			String description = compEl.getAttributeValue("description");
						
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			if(competition.getCountryCode().equals(country) &&
					competition.getDescription().equals(description) &&
					df.format(competition.getEventDate().getTime()).equals(date)) {
				return compEl;
			}
		}
		return null; 
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

}
