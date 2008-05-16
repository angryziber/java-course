package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataWriter;
import net.azib.java.students.t030604.homework.util.TimeFormat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;

/**
 * Class responsible for xml output.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class XmlWriter extends AbstractWriter implements IDataWriter {
	
	private org.dom4j.io.XMLWriter xmlWriter;
 
	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#cleanup()
	 * {@inheritDoc}
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

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#output(java.util.List)
	 * {@inheritDoc}
	 */
	public void output(List<AthleteScore> results) throws WriterException {
		try {
			Document document = generateDocument(results);
			document.setXMLEncoding("UTF-8");
			xmlWriter.write(document); 
			xmlWriter.flush();
		} catch (IOException fatal) {
			throw new WriterException("could not output results", fatal);
		}
	} 
	
	/**
	 * Utility method. Generates XML document from Result list
	 * @param results - <code>sorted</code> list of AthleteScore
	 * @return Document
	 */
	public static Document generateDocument(List<AthleteScore> results) {
		Document document = DocumentHelper.createDocument();
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
			athleteResults.addElement("sprint400").addText(TimeFormat.format(result.getSprint400()));
			athleteResults.addElement("hurdles110").addText(numberFormat.format(result.getHurdles110()));
			athleteResults.addElement("discusThrow").addText(numberFormat.format(result.getDiscusThrow()));
			athleteResults.addElement("poleVault").addText(numberFormat.format(result.getPoleVault()));
			athleteResults.addElement("javelinThrow").addText(numberFormat.format(result.getJavelinThrow()));
			athleteResults.addElement("race1500").addText(TimeFormat.format(result.getRace1500()));
		}
		return document;
	}

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#setup(java.lang.String[])
	 * {@inheritDoc}
	 */
	public void setup(String... args) throws WriterException {
		if (args == null || args.length == 0) {
			throw new WriterException("this output method should be initialized with parameter", null);
		}
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			xmlWriter = new org.dom4j.io.XMLWriter(new OutputStreamWriter(new FileOutputStream(args[0]), "UTF-8"), format);
		} catch (IOException fatal) {
			throw new WriterException("could not open file for writing", fatal);
		}
	}

}
