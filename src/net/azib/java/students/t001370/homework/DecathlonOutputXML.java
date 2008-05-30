package net.azib.java.students.t001370.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * DecathlonOutputXML
 * Class for writing decathlon competition data to XML file
 * @author maksim
 */
public class DecathlonOutputXML extends DecathlonOutput{
	private static final Logger LOG = Logger.getLogger(DecathlonOutputXML.class.getName());
	
	private PrintStream output;
	
	/**
	 * DecathlonOutputXML constructor
	 */
	DecathlonOutputXML(){
		this.output = System.out;
	}
	
	/**
	 * DecathlonOutputXML constructor. Mostly used for testing purpose
	 * @param out - print stream for user interaction
	 */
	DecathlonOutputXML(PrintStream out){
		this.output = out;
	}
	
	/**
	 * Create athlete element
	 * @param athlete - athlete to be compiled
	 * @param xmlDoc  - Documelt from which the element will be created
	 * @param place - athlete's place in the completition
	 * @return
	 */
	private Element createAthleteElementXML(Athlete athlete, Document xmlDoc, String place){
		Element athleteElem = xmlDoc.createElement("athlete");
		
		//set athlete competition place
		Element athPlaceElem = xmlDoc.createElement("place");
		Text athPlaceText = xmlDoc.createTextNode(place);
		athPlaceElem.appendChild(athPlaceText);
		athleteElem.appendChild(athPlaceElem);
		
		//set athlete total score
		Element athTotalElem = xmlDoc.createElement("totalScore");
		Text athTotalText = xmlDoc.createTextNode(
				Integer.toString(athlete.competitionResults.getTotalScore()));
		athTotalElem.appendChild(athTotalText);
		athleteElem.appendChild(athTotalElem);
	
		
		//set name 
		Element athNameElem = xmlDoc.createElement("name");
		Text athNameText = xmlDoc.createTextNode(athlete.getName());
		athNameElem.appendChild(athNameText);
		athleteElem.appendChild(athNameElem);
		
		//set birthday 
		Element athBirthdayElem = xmlDoc.createElement("birthday");
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Text athBirtdayText = xmlDoc.createTextNode(((SimpleDateFormat)df).format(athlete.getBirthday()));
		athBirthdayElem.appendChild(athBirtdayText);
		athleteElem.appendChild(athBirthdayElem);
		
		//set country code
		Element athCountryElem = xmlDoc.createElement("coutryCode");
		Text athCoumtryText = xmlDoc.createTextNode(athlete.getCountryCode());
		athCountryElem.appendChild(athCoumtryText);
		athleteElem.appendChild(athCountryElem);
		
		//...
		Element resultsElem = xmlDoc.createElement("results");
		
		//set 100m sprint result
		Element ath100mElem = xmlDoc.createElement("sprint100m");
		Text ath100mText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResult100mRace()));
		ath100mElem.appendChild(ath100mText);
		resultsElem.appendChild(ath100mElem);
		
		//set long jump result
		Element athLongJumpElem = xmlDoc.createElement("longJump");
		Text athLongJumpText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResultLongJump()));
		athLongJumpElem.appendChild(athLongJumpText);
		resultsElem.appendChild(athLongJumpElem);
		
		//set shot put result
		Element athShotPutElem = xmlDoc.createElement("shotPut");
		Text athShotPutText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResultShotPut()));
		athShotPutElem.appendChild(athShotPutText);
		resultsElem.appendChild(athShotPutElem);

		//set high jump result
		Element athHighJumpElem = xmlDoc.createElement("highJump");
		Text athHighJumpText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResultHighJump()));
		athHighJumpElem.appendChild(athHighJumpText);
		resultsElem.appendChild(athHighJumpElem);

		//set sprint 400m result
		Element athSprint400mElem = xmlDoc.createElement("sprint400m");
		Text athSprint400mText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResult400mSprint()));
		athSprint400mElem.appendChild(athSprint400mText);
		resultsElem.appendChild(athSprint400mElem);
		
		//set hurdles 110m result
		Element athHurdles110mElem = xmlDoc.createElement("hurdles110m");
		Text athHurdles110mText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResult110mHurdles()));
		athHurdles110mElem.appendChild(athHurdles110mText);
		resultsElem.appendChild(athHurdles110mElem);

		//set discus throw result
		Element athDiscusThrowElem = xmlDoc.createElement("discusThrow");
		Text athDiscusThrowText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResultDiscusThrow()));
		athDiscusThrowElem.appendChild(athDiscusThrowText);
		resultsElem.appendChild(athDiscusThrowElem);
		
		//set pole vault result
		Element athPoleVaultElem = xmlDoc.createElement("poleVault");
		Text athPoleVaultText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResultPoleVault()));
		athPoleVaultElem.appendChild(athPoleVaultText);
		resultsElem.appendChild(athPoleVaultElem);

		//set javelin throw result
		Element athJavelinThrowElem = xmlDoc.createElement("javelinThrow");
		Text athJavelinThrowText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResultJavelinThrow()));
		athJavelinThrowElem.appendChild(athJavelinThrowText);
		resultsElem.appendChild(athJavelinThrowElem);

		//set race 1500m result
		Element athRace1500mElem = xmlDoc.createElement("race1500m");
		Text athRace1500mText = xmlDoc.createTextNode(
				Float.toString(athlete.competitionResults.getResult1500mRace()));
		athRace1500mElem.appendChild(athRace1500mText);
		resultsElem.appendChild(athRace1500mElem);

		
		//set results
		athleteElem.appendChild(resultsElem);
		
		return athleteElem;
	}
	
	/**
	 * Create DOM document
	 * @param compatetors - Collection of athletes
	 * @return DOM XML document
	 * @throws ParserConfigurationException
	 */
	protected Document createDecathlonXMLDocument(Collection<Athlete> compatetors) throws ParserConfigurationException {
		
		Document xmlDoc = null;
		
		xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		
		Element decathlonElem = xmlDoc.createElement("decathlon");
		decathlonElem.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		decathlonElem.setAttribute("xsi:noNameSpaceSchemaLocation", "decathlon.xsd");
		
		xmlDoc.appendChild(decathlonElem);
		
		//fill dom tree with athlete data
		int competitorCount = 1;
		for (Athlete athlete : compatetors) {
			decathlonElem.appendChild(createAthleteElementXML(athlete, xmlDoc, calculateCompatetorPlace(competitorCount++, compatetors)));
		}
		
		return xmlDoc;
	}

	
	@Override
	public void writeData(Collection<Athlete> compatetors, File outputFile) throws DecathlonException {
		Document xmlDoc = null;
		
		try {
			xmlDoc = createDecathlonXMLDocument(compatetors);
			
			//serialize xmlDoc
			OutputFormat format = new OutputFormat(xmlDoc, "UTF-8",true);
			//format.setIndenting(true);
			format.setDoctype(null, "decathlon.xsd");
			
			XMLSerializer 	serializer = new XMLSerializer(
					new FileOutputStream(outputFile), format);
			
			serializer.serialize(xmlDoc);
		}
		catch (Exception e) {
			output.println(Errors.ERROR_COULD_NOT_WRITE_TO_XML.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_COULD_NOT_WRITE_TO_XML.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			
			throw new DecathlonException();
		}
	}

}
