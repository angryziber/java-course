package net.azib.java.students.t030726.homework.output;

import java.io.*;
//Xerces 1 or 2 additional classes.
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.RatedDecathlonCompetition;

/**
 * Class produces an XML file containing all the data
 * @author Deniss Nikiforov
 *
 */
public class MarkupLanguageOutput implements IOutput {
	private String filePath = null;
	private RatedDecathlonCompetition competition = null;
	
	public MarkupLanguageOutput(String filePath, RatedDecathlonCompetition competition) throws Exception {
		this.filePath = filePath;
		this.competition = competition;
	}

	/**
	 * This is the core of the class. Produces the full XML document from the RatedDecathlonCompetition
	 * @return
	 * @throws Exception
	 */
	private ContentHandler prepareAndSaveDocument() throws Exception {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputFormat of = new OutputFormat("XML","UTF-16",true);
		of.setMediaType("");
		of.setIndent(1);
		of.setIndenting(true);
		XMLSerializer serializer = new XMLSerializer(fos,of);
//		 SAX2.0 ContentHandler.
		ContentHandler hd = null;
		try {
			hd = serializer.asContentHandler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hd.startDocument();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AttributesImpl atts = new AttributesImpl();
		try {
			hd.startElement("","","participators",atts);
		} catch (SAXException e) {
			e.printStackTrace();
		}
		String[] places = new String[this.competition.length()];
		int[] points = new int[this.competition.length()];
		DecathlonChampionship[] championships = new DecathlonChampionship[this.competition.length()];
		DecathlonChampionship temp = null;
		int counter = 0;
		//This is a workaround for SAX (since it doesn't hold stuff in memory, we have to do it)
		
		while (this.competition.hasNext()) {
			temp = this.competition.getNext();
			places[counter] = temp.getPosition();
			points[counter] = temp.getPoints();
			championships[counter] = temp;
			counter++;
		}
		String tempInfo = null;
		for (int i = 0;i < this.competition.length();i++)
		{
		  atts.clear();
		  atts.addAttribute("","","position","CDATA",places[i]);
		  atts.addAttribute("","","points","CDATA",String.valueOf(points[i]));
		  try {
			hd.startElement("","","participator",atts);
			
			hd.startElement("", "", "name", null);
			tempInfo = championships[i].getParticipator().getParticipatorName();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","name");
			
			hd.startElement("", "", "birthdate", null);
			tempInfo = championships[i].getParticipator().getDateOfBirth();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","birthdate");
			
			hd.startElement("", "", "country", null);
			tempInfo = championships[i].getParticipator().getParticipatorCountryCode();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","country");
			
			hd.startElement("", "", "hundredmetersprint", null);
			tempInfo = championships[i].getHundredMeterSprintRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","hundredmetersprint");
			
			hd.startElement("", "", "longjump", null);
			tempInfo = championships[i].getLongJumpRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","longjump");
			
			hd.startElement("", "", "shotput", null);
			tempInfo = championships[i].getLongJumpRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","shotput");
			
			hd.startElement("", "", "highjump", null);
			tempInfo = championships[i].getHighJumpRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","highjump");
			
			hd.startElement("", "", "fourhundredmetersprint", null);
			tempInfo = championships[i].getFourHundredMeterSprintRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","fourhundredmetersprint");
			
			hd.startElement("", "", "hurdles", null);
			tempInfo = championships[i].getHurdlesRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","hurdles");
			
			hd.startElement("", "", "discusthrow", null);
			tempInfo = championships[i].getDiscusThrowRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","discusthrow");
			
			hd.startElement("", "", "polevault", null);
			tempInfo = championships[i].getPoleVaultRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","polevault");
			
			hd.startElement("", "", "javelinthrow", null);
			tempInfo = championships[i].getJavelinThrowRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","javelinthrow");
			
			hd.startElement("", "", "longrun", null);
			tempInfo = championships[i].getLongRunRawResult();
			hd.characters(tempInfo.toCharArray(),0,tempInfo.length());
			hd.endElement("","","longrun");
			
			hd.endElement("","","participator");
		} catch (SAXException e) {
			e.printStackTrace();
		}
		  
		}
		hd.endElement("","","participators");
		hd.endDocument();
		fos.close();
		return hd;
	}
	
	/**
	 * Generate and dump
	 */
	public void dump() {
		try {
			this.prepareAndSaveDocument();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
