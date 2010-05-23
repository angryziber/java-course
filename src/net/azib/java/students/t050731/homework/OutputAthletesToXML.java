package net.azib.java.students.t050731.homework;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

/**
 * OutputAthletesToXML
 * 
 * This class handles the output to xml file
 * 
 * @author Raigo
 */
public class OutputAthletesToXML {
	/**
	 * This method outputs data to xml file
	 * 
	 * @param athletes
	 *            arraylist containing athlete objects
	 * @param fileName
	 *            output file path
	 */
	public String createXMLOutput(ArrayList<Athlete> athletes, String fileName) {

		try {
			if (athletes.size() == 0)
				return "";

			HelperMethods helper = new HelperMethods();
			Collections.sort(athletes, new ScoreComparator());
			helper.assignPositions(athletes);

			// Create document
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			DecimalFormatSymbols dfs = new DecimalFormatSymbols();
			dfs.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.00", dfs);

			// Create root element
			Element rootElement = document.createElement("DecathlonResults");
			document.appendChild(rootElement);

			// Add athlete data
			for (Athlete a : athletes) {
				Element em = document.createElement("Athlete");

				Element emName = document.createElement("Name");
				emName.appendChild(document.createTextNode(a.getName()));
				em.appendChild(emName);

				Element emDate = document.createElement("Birthdate");
				emDate.appendChild(document.createTextNode(a.getDateOfBirthAsShortString()));
				em.appendChild(emDate);

				Element emCountry = document.createElement("Country");
				emCountry.appendChild(document.createTextNode(a.getCountry()));
				em.appendChild(emCountry);

				Element emSprint100 = document.createElement("ShortSprintResult");
				emSprint100.appendChild(document.createTextNode(df.format(a.getShortSprintResult())));
				em.appendChild(emSprint100);

				Element emLongJump = document.createElement("LongJumpResult");
				emLongJump.appendChild(document.createTextNode(df.format(a.getLongJumpResult())));
				em.appendChild(emLongJump);

				Element emShotPut = document.createElement("ShotPutResult");
				emShotPut.appendChild(document.createTextNode(df.format(a.getShotPutResult())));
				em.appendChild(emShotPut);

				Element emHighJump = document.createElement("HighJumpResult");
				emHighJump.appendChild(document.createTextNode(df.format(a.getHighJumpResult())));
				em.appendChild(emHighJump);

				Element emLongSprint = document.createElement("LongSprintResult");
				emLongSprint.appendChild(document.createTextNode(helper.convertSecondsToMinutes(a.getLongSprintResult())));
				em.appendChild(emLongSprint);

				Element emHurdles = document.createElement("HurdlesResult");
				emHurdles.appendChild(document.createTextNode(df.format(a.getHurdlesResult())));
				em.appendChild(emHurdles);

				Element emDiscus = document.createElement("DiscusThrowResult");
				emDiscus.appendChild(document.createTextNode(df.format(a.getDiscusThrowResult())));
				em.appendChild(emDiscus);

				Element emPolevault = document.createElement("PoleVaultResult");
				emPolevault.appendChild(document.createTextNode(df.format(a.getPoleVaultResult())));
				em.appendChild(emPolevault);

				Element emJavelinThrow = document.createElement("JavelinThrowResult");
				emJavelinThrow.appendChild(document.createTextNode(df.format(a.getJavelinThrowResult())));
				em.appendChild(emJavelinThrow);

				Element emRace = document.createElement("RaceResult");
				emRace.appendChild(document.createTextNode(helper.convertSecondsToMinutes(a.getRaceResult())));
				em.appendChild(emRace);

				Element emTotal = document.createElement("TotalScore");
				emTotal.appendChild(document.createTextNode(String.valueOf(a.getTotalScore())));
				em.appendChild(emTotal);

				Element emPos = document.createElement("Position");
				emPos.appendChild(document.createTextNode(a.getPosition()));
				em.appendChild(emPos);

				rootElement.appendChild(em);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(fileName);
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, helper.getFullPath("athletes.dtd"));
			
			System.out.println("Displaying " + athletes.size() + " athlete(s) in xml output:");
			transformer.transform(source, result);
		}
		catch (Exception e) {
			System.out.println("Unable to create xml file.");
		}
		return fileName;
	}
}
