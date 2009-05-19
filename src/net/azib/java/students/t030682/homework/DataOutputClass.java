package net.azib.java.students.t030682.homework;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jdom.*;
import org.jdom.output.XMLOutputter;

/**
 * DataOutputClass
 * 
 * @author aplotn
 */
public class DataOutputClass { 

	public int[] countPlaces(List<DecathlonResultsRecord> results) {
		int places[] = new int[results.size()];
		int tmpPlace;
		int numberOfSamePlaces = 0;
		int tmpScore = 0;
		for (DecathlonResultsRecord hehe : results) {
			tmpPlace = (results.indexOf(hehe));
			if (hehe.totalScore == tmpScore) {
				++numberOfSamePlaces;
				tmpPlace = tmpPlace-numberOfSamePlaces;
			} else numberOfSamePlaces = 0;
			places[results.indexOf(hehe)] = tmpPlace + 1;
			tmpScore = hehe.totalScore;
		}
		return places;
	}

	public void consoleWriter(List<DecathlonResultsRecord> results) {
		System.out.println("+++++++++++++++++\nAthletes results:\n+++++++++++++++++\n");
		for (DecathlonResultsRecord consoleResult : results) 
			System.out.println(countPlaces(results)[results.indexOf(consoleResult)] + ":   " + consoleResult);
	}

	public void csvWriter(List<DecathlonResultsRecord> results, String filename) {
		try {
			FileWriter fstream = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fstream);
			for (DecathlonResultsRecord csvResult : results) {
				out.write(countPlaces(results)[results.indexOf(csvResult)] + "," + csvResult.totalScore + ",\"" + csvResult.name + "\","
						+ csvResult.dateOfBirth + "," + csvResult.country + "," + csvResult.resultOf100mSprint + "," + csvResult.resultOfLongJump
						+ "," + csvResult.resultOfShotPut + "," + csvResult.resultOfHighJump + "," + csvResult.resultOf400mSprint + ","
						+ csvResult.resultOf110mHurdles + "," + csvResult.resultOfDiscusThrow + "," + csvResult.resultOfPoleVault + ","
						+ csvResult.resultOfJavelinThrow + "," + csvResult.resultOf1500Race);
				out.newLine();
			}
			out.close();
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	public Document buildDocument (List<DecathlonResultsRecord> results) {
		Element root = new Element("Decathlon");
		Element[] athlete = new Element[countPlaces(results).length];
		for (DecathlonResultsRecord docResult : results) {
			root.addContent("\n ");
			athlete[results.indexOf(docResult)] = new Element("athlete");
			
			Element place = new Element("place");
			place.setText(Integer.toString(countPlaces(results)[results.indexOf(docResult)]));
			Element score = new Element("points");
			score.addContent(Integer.toString(docResult.totalScore));
			Element name = new Element("name");
			name.addContent(docResult.name);
			Element birthdate = new Element("dateOfBirth");
			birthdate.addContent(docResult.dateOfBirth);
			Element country = new Element("country");
			country.addContent(docResult.country);
			Element resultOf100mSprint = new Element("resultOf100mSprint");
			resultOf100mSprint.addContent(Double.toString(docResult.resultOf100mSprint));
			Element resultOfLongJump = new Element("resultOfLongJump");
			resultOfLongJump.addContent(Double.toString(docResult.resultOfLongJump));
			Element resultOfShotPut = new Element("resultOfShotPut");
			resultOfShotPut.addContent(Double.toString(docResult.resultOfShotPut));
			Element resultOfHighJump = new Element("resultOfHighJump");
			resultOfHighJump.addContent(Double.toString(docResult.resultOfHighJump));
			Element resultOf400mSprint = new Element("resultOf400mSprintp");
			resultOf400mSprint.addContent(Double.toString(docResult.resultOf400mSprint));
			Element resultOf110mHurdles = new Element("resultOf110mHurdles");
			resultOf110mHurdles.addContent(Double.toString(docResult.resultOf110mHurdles));
			Element resultOfDiscusThrow = new Element("resultOfDiscusThrow");
			resultOfDiscusThrow.addContent(Double.toString(docResult.resultOfDiscusThrow));
			Element resultOfPoleVault = new Element("resultOfPoleVault");
			resultOfPoleVault.addContent(Double.toString(docResult.resultOfPoleVault));
			Element resultOfJavelinThrow = new Element("resultOfJavelinThrow");
			resultOfJavelinThrow.addContent(Double.toString(docResult.resultOfJavelinThrow));
			Element resultOf1500mRace = new Element("resultOf1500mRace");
			resultOf1500mRace.addContent(Double.toString(docResult.resultOf1500Race));
			
			athlete[results.indexOf(docResult)].addContent("\n  ").addContent(place).addContent("\n  ").addContent(score).
			addContent("\n  ").addContent(name).addContent("\n  ").addContent(birthdate).addContent("\n  ").addContent(country).
			addContent("\n  ").addContent(resultOf100mSprint).addContent("\n  ").addContent(resultOfLongJump).addContent("\n  ").
			addContent(resultOfShotPut).addContent("\n  ").addContent(resultOfHighJump).addContent("\n  ").addContent(resultOf400mSprint).
			addContent("\n  ").addContent(resultOf110mHurdles).addContent("\n  ").addContent(resultOfDiscusThrow).addContent("\n  ").
			addContent(resultOfPoleVault).addContent("\n  ").addContent(resultOfJavelinThrow).addContent("\n  ").addContent(resultOf1500mRace).
			addContent("\n ");
		
			root.addContent(athlete[results.indexOf(docResult)]);
			//root.addContent("\n ");
		}
		return new Document(root);
	}
	
	public void xmlWriter (Document doc, String filename) throws FileNotFoundException, IOException {
		XMLOutputter outputter = new XMLOutputter();
		outputter.output(doc, new FileOutputStream(filename));
	}
	
	
	public void htmlWriter (Document doc, String filename) throws TransformerException, FileNotFoundException, IOException{
		XMLOutputter outputter = new XMLOutputter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		outputter.output(doc, out);
		Transformer serializer = TransformerFactory.newInstance().newTransformer(new StreamSource(DataOutputClass.class.getResource("decathlon.xsl").toString()));
		serializer.transform(new StreamSource(new ByteArrayInputStream(out.toByteArray())), new StreamResult(new File(filename)));
		
		
	}

}