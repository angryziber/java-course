package net.azib.java.students.t093759.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static net.azib.java.students.t093759.homework.DecathlonEvent.*;

/**
 * This class should be used to output a list of athletes as xml data.
 *
 * @author dionis
 *         5/30/114:55 AM
 */
public class XMLOutput implements AthletesOutput {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("d.MM.yyyy");
	private static final NumericDataRepresentHelper NUMERIC_DATA_REPRESENT_HELPER = NumericDataRepresentHelper.getInstance();

	@Override
	public void output(List<Athlete> athletes, Object... additionalParameters) {
		if (additionalParameters.length != 1)
			throw new IllegalArgumentException("Only one parameter should be given.");
		if (!(additionalParameters[0] instanceof String))
			throw new IllegalArgumentException("Parameter should be string!");
		try {
			outputXmlForAllAthletes(athletes, (String) additionalParameters[0]);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void outputXmlForAllAthletes(List<Athlete> athletes, String fileName) throws Exception {
		Collections.sort(athletes);

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		Document doc = builder.newDocument();

		Element decathlon = doc.createElement("decathlon");

		doc.appendChild(decathlon);

		for (Athlete athlete : athletes) {
			decathlon.appendChild(getAthleteTagFilledWithDate(doc, athlete));
		}

		Transformer serializer = TransformerFactory.newInstance().newTransformer();
		serializer.transform(new DOMSource(doc), new StreamResult(new File(fileName)));
	}

	private Element getAthleteTagFilledWithDate(Document doc, Athlete athlete) {
		Element athleteTag = doc.createElement("athlete");

		createAndAppendNameElement(doc, athlete, athleteTag);
		createAndAppendCountryISO2LetterCode(doc, athlete, athleteTag);
		createAndAppendDateOfBirth(doc, athlete, athleteTag);
		createAndAppendOneHundredMeterSprint(doc, athlete, athleteTag);
		createAndAppendLongJump(doc, athlete, athleteTag);
		createAndAppendShotPut(doc, athlete, athleteTag);
		createAndAppendHighJump(doc, athlete, athleteTag);
		createAndAppendFourHundredMeterSprint(doc, athlete, athleteTag);
		createAndAppendOneHundredTenMeterHurdles(doc, athlete, athleteTag);
		createAndAppendDicusThrow(doc, athlete, athleteTag);
		createAndAppendPoleVault(doc, athlete, athleteTag);
		createAndAppendJavelinThrow(doc, athlete, athleteTag);
		createAndAppendThousandFiveHundredMeterSpring(doc, athlete, athleteTag);

		return athleteTag;
	}

	private void createAndAppendThousandFiveHundredMeterSpring(Document doc, Athlete athlete, Element athleteTag) {
		Element thousandFiveHundredMeterSpring = doc.createElement("thousandFiveHundredMeterSpring");
		thousandFiveHundredMeterSpring.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMinuteAndSeconds(athlete.get(THOUSAND_FIVE_HUNDRED_METER_SPRINT))));
		athleteTag.appendChild(thousandFiveHundredMeterSpring);
	}

	private void createAndAppendJavelinThrow(Document doc, Athlete athlete, Element athleteTag) {
		Element javelinThrow = doc.createElement("javelinThrow");
		javelinThrow.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(JAVELIN_THROW))));
		athleteTag.appendChild(javelinThrow);
	}

	private void createAndAppendPoleVault(Document doc, Athlete athlete, Element athleteTag) {
		Element poleVault = doc.createElement("poleVault");
		poleVault.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(POLE_VAULT))));
		athleteTag.appendChild(poleVault);
	}

	private void createAndAppendDicusThrow(Document doc, Athlete athlete, Element athleteTag) {
		Element discusThrow = doc.createElement("discusThrow");
		discusThrow.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(DISCUS_THROW))));
		athleteTag.appendChild(discusThrow);
	}

	private void createAndAppendOneHundredTenMeterHurdles(Document doc, Athlete athlete, Element athleteTag) {
		Element oneHundredTenMeterHurdles = doc.createElement("oneHundredTenMeterHurdles");
		oneHundredTenMeterHurdles.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representSeconds(athlete.get(ONE_HUNDRED_TEN_METER_HURDLES))));
		athleteTag.appendChild(oneHundredTenMeterHurdles);
	}

	private void createAndAppendFourHundredMeterSprint(Document doc, Athlete athlete, Element athleteTag) {
		Element fourHundredMeterSprint = doc.createElement("fourHundredMeterSprint");
		fourHundredMeterSprint.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMinuteAndSeconds(athlete.get(FOUR_HUNDRED_METER_SPRINT))));
		athleteTag.appendChild(fourHundredMeterSprint);
	}

	private void createAndAppendHighJump(Document doc, Athlete athlete, Element athleteTag) {
		Element highJump = doc.createElement("highJump");
		highJump.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(HIGH_JUMP))));
		athleteTag.appendChild(highJump);
	}

	private void createAndAppendShotPut(Document doc, Athlete athlete, Element athleteTag) {
		Element shotPut = doc.createElement("shotPut");
		shotPut.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(SHOT_PUT))));
		athleteTag.appendChild(shotPut);
	}

	private void createAndAppendLongJump(Document doc, Athlete athlete, Element athleteTag) {
		Element longJump = doc.createElement("longJump");
		longJump.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(LONG_JUMP))));
		athleteTag.appendChild(longJump);
	}

	private void createAndAppendOneHundredMeterSprint(Document doc, Athlete athlete, Element athleteTag) {
		Element oneHundredMeterSprint = doc.createElement("oneHundredMeterSprint");
		oneHundredMeterSprint.appendChild(doc.createTextNode(NUMERIC_DATA_REPRESENT_HELPER.representSeconds(athlete.get(ONE_HUNDRED_METER_SPRINT))));
		athleteTag.appendChild(oneHundredMeterSprint);
	}

	private void createAndAppendDateOfBirth(Document doc, Athlete athlete, Element athleteTag) {
		Element dateOfBirth = doc.createElement("dateOfBirth");
		dateOfBirth.appendChild(doc.createTextNode(DATE_FORMAT.format(athlete.getDateOfBirth().getTime())));
		athleteTag.appendChild(dateOfBirth);
	}

	private void createAndAppendCountryISO2LetterCode(Document doc, Athlete athlete, Element athleteTag) {
		Element countryISO2LetterCode = doc.createElement("countryISO2LetterCode");
		countryISO2LetterCode.appendChild(doc.createTextNode(athlete.getCountryISO2LetterCode()));
		athleteTag.appendChild(countryISO2LetterCode);
	}

	private void createAndAppendNameElement(Document doc, Athlete athlete, Element athleteTag) {
		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(athlete.getName()));
		athleteTag.appendChild(name);
	}
}
