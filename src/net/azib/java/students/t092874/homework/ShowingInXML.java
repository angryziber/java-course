package net.azib.java.students.t092874.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

/**
 * ShowingInXML
 * 
 * @author Aleksandr GLadki
 */
class ShowingInXML {
	private String fileOrPath = "";

	/**
	 * 
	 */
	ShowingInXML(String fileName) {
		this.fileOrPath = fileName;
	}

	/**
	 * @return the fileOrPath
	 */
	public String getFileOrPath() {
		return fileOrPath;
	}

	/**
	 * 
	 * @param create
	 *            xml file from source List<result>
	 */
	public void createXml(List<Result> list) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setValidating(true);
			documentBuilderFactory.setNamespaceAware(true);
			documentBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");

			documentBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", new InputSource(
					new FileInputStream(System.getProperty("user.dir") + Constants.MY_PATH + "results.xsd")));

			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			// documentBuilder.setErrorHandler(new MyErrorHandler());

			Document document = documentBuilder.newDocument();

			Element results = document.createElement("results");
			document.appendChild(results);
			int placeNum = 0, pointsNum = 0;
			for (Result result : list) {
				Element athlete = document.createElement("athlete");
				results.appendChild(athlete);

				if (placeNum == 0) {
					placeNum = 1;
					pointsNum = result.getPoints();
				}
				else if (result.getPoints() != pointsNum) {
					placeNum++;
				}
				pointsNum = result.getPoints();

				Element place = document.createElement("place");
				Text placeText = document.createTextNode(String.valueOf(placeNum));
				place.appendChild(placeText);
				athlete.appendChild(place);

				Element points = document.createElement("points");
				Text pointsText = document.createTextNode(String.valueOf(result.getPoints()));
				points.appendChild(pointsText);
				athlete.appendChild(points);

				Element name = document.createElement("name");
				Text nameText = document.createTextNode(result.getAthlete().getName());
				name.appendChild(nameText);
				athlete.appendChild(name);

				Element birthday = document.createElement("birthday");
				Text birthdayText = document.createTextNode(Util.convertDateToString(result.getAthlete().getBirthDate()));
				birthday.appendChild(birthdayText);
				athlete.appendChild(birthday);

				Element country = document.createElement("country");
				Text countryText = document.createTextNode(result.getAthlete().getCountryCode());
				country.appendChild(countryText);
				athlete.appendChild(country);

				Element resultAll = document.createElement("result");
				Element sprint_100Name = document.createElement("sprint_100");
				Text sprint_100Text = document.createTextNode(String.valueOf(result.getSprint100()));
				sprint_100Name.appendChild(sprint_100Text);
				resultAll.appendChild(sprint_100Name);

				Element long_jumpName = document.createElement("long_jump");
				Text long_jumpText = document.createTextNode(String.valueOf(result.getLongJump()));
				long_jumpName.appendChild(long_jumpText);
				resultAll.appendChild(long_jumpName);

				Element short_putName = document.createElement("short_put");
				Text short_putText = document.createTextNode(String.valueOf(result.getShortPut()));
				short_putName.appendChild(short_putText);
				resultAll.appendChild(short_putName);

				Element high_jumpName = document.createElement("high_jump");
				Text high_jumpText = document.createTextNode(String.valueOf(result.getHighJump()));
				high_jumpName.appendChild(high_jumpText);
				resultAll.appendChild(high_jumpName);

				Element sprint_400Name = document.createElement("sprint_400");
				Text sprint_400Text = document.createTextNode(Util.convertNumberInSecondToString(result.getSprint400()));
				sprint_400Name.appendChild(sprint_400Text);
				resultAll.appendChild(sprint_400Name);

				Element discus_throwName = document.createElement("discus_throw");
				Text discus_throwText = document.createTextNode(String.valueOf(result.getDiscusThrow()));
				discus_throwName.appendChild(discus_throwText);
				resultAll.appendChild(discus_throwName);

				Element pole_vaultName = document.createElement("pole_vault");
				Text pole_vaultText = document.createTextNode(String.valueOf(result.getPoleVault()));
				pole_vaultName.appendChild(pole_vaultText);
				resultAll.appendChild(pole_vaultName);

				Element javelin_throwName = document.createElement("javelin_throw");
				Text javelin_throwText = document.createTextNode(String.valueOf(result.getJavelinThrow()));
				javelin_throwName.appendChild(javelin_throwText);
				resultAll.appendChild(javelin_throwName);

				Element race_1500Name = document.createElement("race_1500");
				Text race_1500Text = document.createTextNode(Util.convertNumberInSecondToString(result.getRace()));
				race_1500Name.appendChild(race_1500Text);
				resultAll.appendChild(race_1500Name);

				athlete.appendChild(resultAll);
			}

			DOMSource domSource = new DOMSource(document);

			File theDir = new File(Util.getDirFromString(getFileOrPath()));
			// if the directory does not exist, create it
			if (!theDir.exists()) {
				theDir.mkdir();
			}
			
			StreamResult streamResult = new StreamResult(new FileOutputStream(getFileOrPath()));
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(domSource, streamResult);

		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
}
