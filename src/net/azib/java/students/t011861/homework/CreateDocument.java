package net.azib.java.students.t011861.homework;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * CreateDocument
 *
 * @author 011861
 */

public class CreateDocument {
    /**This function is responsible for creating XML tree.
     * It is necessary to generate XML and HTML output files.
	 * @param List<String[]> It consists of data which comes 
	 * from module of ProcessedData! There are all needed data we need to send to output.
	 * @return Function returns document which has type of Document!
	 */
	public Document createDocument(List<String[]> completeData) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("athletes");
		for (String[] athleteData : completeData) 
		{
			Element athlete = root.addElement("athlete");
			@SuppressWarnings("unused")
			Element name = athlete.addElement("name").addText(athleteData[0]);
			@SuppressWarnings("unused")
			Element date_of_birth = athlete.addElement("date").addText(athleteData[1]);
			@SuppressWarnings("unused")
			Element country = athlete.addElement("country").addText(athleteData[2]);
			@SuppressWarnings("unused")
			Element hundred_m_run = athlete.addElement("hundred_m_run").addText(athleteData[3]);
			@SuppressWarnings("unused")
			Element long_jump = athlete.addElement("long_jump").addText(athleteData[4]);
			@SuppressWarnings("unused")
			Element shot_put = athlete.addElement("shot_put").addText(athleteData[5]);
			@SuppressWarnings("unused")
			Element high_jump = athlete.addElement("high_jump").addText(athleteData[6]);
			@SuppressWarnings("unused")
			Element fourh_m_run = athlete.addElement("fourh_m_run").addText(athleteData[7]);
			@SuppressWarnings("unused")
			Element hurdles = athlete.addElement("hurdles").addText(athleteData[8]);
			@SuppressWarnings("unused")
			Element discus_throw = athlete.addElement("discus_throw").addText(athleteData[9]);
			@SuppressWarnings("unused")
			Element pole_vault = athlete.addElement("pole_vault").addText(athleteData[10]);
			@SuppressWarnings("unused")
			Element javelin_throw = athlete.addElement("javelin_throw").addText(athleteData[11]);
			@SuppressWarnings("unused")
			Element running = athlete.addElement("running").addText(athleteData[12]);
			/**
			Element scores = athlete.addElement("results");
			int noComma = athleteData.length-3;
			for (int i = 3; i < (athleteData.length - 2); i++) 
			{
				if (i != noComma)
				{
					@SuppressWarnings("unused")
					Element score = scores.addText(athleteData[i] + ", ");
				}
				else
				{
					@SuppressWarnings("unused")
					Element score = scores.addText(athleteData[i]);
				}
			}
			**/
			@SuppressWarnings("unused")
			Element points = athlete.addElement("points").addText(athleteData[13]);
			@SuppressWarnings("unused")
			Element place = athlete.addElement("place").addText(athleteData[14]);
		}		
		return document;
	}
}