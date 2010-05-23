package net.azib.java.students.t050731.homework;

/**
 * OutputAthletesToHtml
 *
 * This class handles the output to html file
 * 
 * @author Raigo
 */

import javax.xml.transform.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OutputAthletesToHTML {
	/**
	 * This method outputs data to html file
	 * 
	 * @param athletes
	 *            arraylist containing athlete objects
	 * @param fileName
	 *            output file path
	 */
	protected String createHTMLOutput(ArrayList<Athlete> athletes, String fileName) {
		try {
			HelperMethods helper = new HelperMethods();
			Collections.sort(athletes, new ScoreComparator());

			String fileXSL = helper.getFullPath("athletes.xsl");

			if (helper.checkIfFileExits(fileXSL) == false) {
				System.out.println("Required stylesheet file does not exist: ");
				System.out.println(fileXSL);
				return "";
			}
						
			OutputAthletesToXML outputToXML = new OutputAthletesToXML();
			String helperName;

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(fileXSL));

			System.out.println("Creating xml file for transformation.");
			helperName = createPath(fileName, ".xml");
			System.out.println(outputToXML.createXMLOutput(athletes, helper.getFullPath(helperName)));
			
			System.out.println("Displaying " + athletes.size() + " athlete(s) in html output:");
			transformer.transform(new javax.xml.transform.stream.StreamSource(helper.getFullPath(helperName)),
					new javax.xml.transform.stream.StreamResult(new FileOutputStream(helper.getFullPath(fileName))));
		}
		catch (Exception e) {
			System.out.println("Unable to create HTML file.");
		}
		return fileName;
	}

	private String createPath(String fileName, String extension) {
		if (fileName.contains(".") == true)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		if (fileName.contains("\\") == true)
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
		return fileName.concat(extension);
	}
}