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
	public Document createDocument(List<String[]> completeData) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("athletes");
		for (String[] athleteData : completeData) {
			Element athlete = root.addElement("athlete");
			@SuppressWarnings("unused")
			Element name = athlete.addElement("name").addText(athleteData[0]);
			@SuppressWarnings("unused")
			Element date_of_birth = athlete.addElement("date").addText(athleteData[1]);
			@SuppressWarnings("unused")
			Element country = athlete.addElement("country").addText(athleteData[2]);
			Element scores = athlete.addElement("results");
			for (int i = 3; i < (athleteData.length - 2); i++) {
				@SuppressWarnings("unused")
				Element score = scores.addText(athleteData[i] + ", ");
			}
			@SuppressWarnings("unused")
			Element points = athlete.addElement("points").addText(athleteData[13]);
			@SuppressWarnings("unused")
			Element place = athlete.addElement("place").addText(athleteData[14]);
		}		
		return document;
	}
}