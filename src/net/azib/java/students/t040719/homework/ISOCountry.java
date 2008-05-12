package net.azib.java.students.t040719.homework;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Country - class that holds all the possible valid country codes in ISO 2-letter format
 * Fetches the results from an xml file
 * 
 * @version 1.0
 * @author Romi Agar
 */
public class ISOCountry {
	private static final Logger LOG = Logger.getLogger(ISOCountry.class.getSimpleName());

	private static Map<String,String> countries = new TreeMap<String,String>();
	
	static{
			try {
				loadCountries();
			}
			catch (SAXException e) {
				LOG.log(Level.SEVERE, "Cannot load countries.", e);
			}
			catch (IOException e) {
				LOG.log(Level.SEVERE, "Cannot load countries.", e);
			}
			catch (ParserConfigurationException e) {
				LOG.log(Level.SEVERE, "Cannot load countries.", e);
			}
			catch (URISyntaxException e){
				LOG.log(Level.SEVERE, "Cannot load countries.", e);				
			}

	}
	
	/**
	 * Checks if given string is a valid country code
	 * @param isoCode country code string
	 * @return true if is valid, false otherwise
	 */
	public static boolean isValidCountryCode(String isoCode){
		return ISOCountry.countries.containsKey(isoCode);
	}
	
	/**
	 * Returns a country name for given iso country code
	 * @param isoCode country code string
	 * @return country name if isoCode is valid, empty string otherwise
	 */
	public static String getCountryName(String isoCode){
		if (ISOCountry.isValidCountryCode(isoCode))
			return ISOCountry.countries.get(isoCode);
		else
			return "";
	}
	
	//@SuppressWarnings("unchecked") // Needed because of generics
	private static void loadCountries() throws SAXException, IOException, ParserConfigurationException, URISyntaxException{
		File file = new File(ISOCountry.class.getResource(("xml/countries.xml")).toURI().getPath());
		NodeList nodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("country");
		for (int i = 0; i < nodes.getLength(); i++) {
			Element e = (Element) nodes.item(i);
			ISOCountry.countries.put(e.getElementsByTagName("code").item(0).getTextContent(), e.getElementsByTagName("name").item(0).getTextContent());
		}
		/*SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(ISOCountry.class.getResourceAsStream("xml/countries.xml"));
		
		List<Element> children = doc.getRootElement().getChildren("country");
		for (Element country : children) {
			ISOCountry.countries.put(country.getChildText("code"), country.getChildText("name"));
		}*/
	}
	
}