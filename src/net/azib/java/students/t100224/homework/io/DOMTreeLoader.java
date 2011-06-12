package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import java.util.List;
import java.util.Map;

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

				for(Map.Entry<String, Float> p : result.getPerformances().entrySet()){
					Element element = document.createElement(p.getKey());
					element.appendChild(document.createTextNode(p.getValue().toString()));
					athlete.appendChild(element);
				}

			}
		} catch (ParserConfigurationException e) {
			LOG.error(e.getMessage());
		}
		return new DOMSource(document);
	}

}