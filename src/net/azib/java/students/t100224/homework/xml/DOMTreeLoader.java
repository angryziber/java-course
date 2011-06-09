package net.azib.java.students.t100224.homework.xml;

import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import java.util.List;

public class DOMTreeLoader {

	private final Logger LOG = Logger.getLogger(getClass().getName());

	/**
	 * Creates a Document Object Model tree
	 *
	 * @param results - Array list of athletes and their decathlon results
	 * @return Document Object Model tree
	 */
	public DOMSource createDOMTree(List<Result> results) {
		DocumentBuilder builder;
		Document document = null;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = builder.newDocument();

			Element root = document.createElement("athletes");
			document.appendChild(root);

			for (Result result : results) {

				Element athlete = document.createElement("athlete");
				root.appendChild(athlete);
				athlete.setAttribute("scores", Integer.toString(result.getTotalScore()));
				athlete.setAttribute("place", Integer.toString(results.indexOf(result) + 1));

				Element name = document.createElement("name");
				name.appendChild(document.createTextNode(result.getAthlete().getName()));
				athlete.appendChild(name);

				Element country = document.createElement("country");
				country.appendChild(document.createTextNode(result.getAthlete().getCountry()));
				athlete.appendChild(country);

				Element dateOfBirth = document.createElement("date_of_birth");
				dateOfBirth.appendChild(document.createTextNode(result.getAthlete().getDateOfBirth().toString()));
				athlete.appendChild(dateOfBirth);

				Element sprint100m = document.createElement("sprint_100");
				sprint100m.appendChild(document.createTextNode(Float.toString(result.getSprint100())));
				athlete.appendChild(sprint100m);

				Element longJump = document.createElement("long_jump");
				longJump.appendChild(document.createTextNode(Float.toString(result.getLongJump())));
				athlete.appendChild(longJump);

				Element shotPut = document.createElement("shot_put");
				shotPut.appendChild(document.createTextNode(Float.toString(result.getShotPut())));
				athlete.appendChild(shotPut);

				Element highJump = document.createElement("high_jump");
				highJump.appendChild(document.createTextNode(Float.toString(result.getHighJump())));
				athlete.appendChild(highJump);

				Element sprint400 = document.createElement("sprint_400");
				sprint400.appendChild(document.createTextNode(Float.toString(result.getSprint400())));
				athlete.appendChild(sprint400);

				Element hurdles110 = document.createElement("hurdles_110");
				hurdles110.appendChild(document.createTextNode(Float.toString(result.getHurdles110())));
				athlete.appendChild(hurdles110);

				Element discusThrow = document.createElement("discus_throw");
				discusThrow.appendChild(document.createTextNode(Float.toString(result.getDiscusThrow())));
				athlete.appendChild(discusThrow);

				Element poleVault = document.createElement("pole_vault");
				poleVault.appendChild(document.createTextNode(Float.toString(result.getPoleVault())));
				athlete.appendChild(poleVault);

				Element javelinThrow = document.createElement("javelin_throw");
				javelinThrow.appendChild(document.createTextNode(Float.toString(result.getJavelinThrow())));
				athlete.appendChild(javelinThrow);

				Element race1500 = document.createElement("race_1500");
				race1500.appendChild(document.createTextNode(Float.toString(result.getRace1500())));
				athlete.appendChild(race1500);


			}
		} catch (ParserConfigurationException e) {
			LOG.error(e.getMessage());
		}
		return new DOMSource(document);
	}

}