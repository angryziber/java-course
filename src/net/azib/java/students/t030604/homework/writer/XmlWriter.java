package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.IDataWriter;
import net.azib.java.students.t030604.homework.domain.AthleteScore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class XmlWriter extends AbstractWriter implements IDataWriter {
	
	private org.dom4j.io.XMLWriter xmlWriter;

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#cleanup()
	 */
	public void cleanup() throws WriterException {
		try {
			if (xmlWriter!= null) {
				xmlWriter.close();
			}
		} catch (IOException fatal) {
			throw new WriterException("cleanup failed", fatal);
		}
	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#output(java.util.List)
	 */
	public void output(List<AthleteScore> results) throws WriterException {
		try {
			Document document = generateDocument(results); 
			System.out.println(document.asXML());
			xmlWriter.write(document);
			xmlWriter.flush();
		} catch (IOException fatal) {
			throw new WriterException("could not output results", fatal);
		}
	} 
	
	public Document generateDocument(List<AthleteScore> results) {
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("utf-8");
		Element root = document.addElement("ranks");
		
		for (AthleteScore result : results) {
			Element rank = root.addElement("rank")
					.addAttribute("place", result.getRank()+"");
			if(result.getSharedRank() > 0) {
				rank.addAttribute("sharedPlace", result.getSharedRank()+"");
			}
			rank.addAttribute("points", result.getPoints()+"");
			rank.addElement("athlete")
					.addAttribute("name", result.getName())
					.addAttribute("birthDate", dateFormat.format(result.getBirthDate()))
					.addAttribute("countryCode", result.getCountry());
			Element athleteResults = rank.addElement("results");
			athleteResults.addElement("sprint100").addText(numberFormat.format(result.getSprint100()));
			athleteResults.addElement("longJump").addText(numberFormat.format(result.getLongJump()));
			athleteResults.addElement("shotPut").addText(numberFormat.format(result.getShotPut()));
			athleteResults.addElement("highJump").addText(numberFormat.format(result.getHighJump()));
			athleteResults.addElement("sprint400").addText(timeFormat.format(result.getSprint400()));
			athleteResults.addElement("hurdles110").addText(numberFormat.format(result.getHurdles110()));
			athleteResults.addElement("discusThrow").addText(numberFormat.format(result.getDiscusThrow()));
			athleteResults.addElement("poleVault").addText(numberFormat.format(result.getPoleVault()));
			athleteResults.addElement("javelinThrow").addText(numberFormat.format(result.getJavelinThrow()));
			athleteResults.addElement("race1500").addText(timeFormat.format(result.getRace1500()));
		}
		return document;
	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#setup(java.lang.String[])
	 */
	public void setup(String... args) throws WriterException {
		
		try {
			xmlWriter = new org.dom4j.io.XMLWriter(new FileWriter(new File("output.xml")), OutputFormat.createPrettyPrint());
		} catch (IOException fatal) {
			throw new WriterException("could not open file for writing", fatal);
		}
	}

}
