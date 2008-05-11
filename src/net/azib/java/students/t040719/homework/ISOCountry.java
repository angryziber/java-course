package net.azib.java.students.t040719.homework;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


/**
 * Country - class that holds all the possible valid country codes in ISO 2-letter format
 * Fetches the results from an xml file
 * 
 * @version 1.0
 * @author Romi Agar
 */
public class ISOCountry {
	private static Map<String,String> countries = new TreeMap<String,String>();
	
	static{
		try {
			loadCountries();
		}
		catch (JDOMException e) {
			System.err.println(e);
		}
		catch (IOException e) {
			System.err.println(e);
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
	
	@SuppressWarnings("unchecked") // Needed because of generics
	private static void loadCountries() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(ISOCountry.class.getResourceAsStream("xml/countries.xml"));
		
		List<Element> children = doc.getRootElement().getChildren("country");
		for (Element country : children) {
			ISOCountry.countries.put(country.getChildText("code"), country.getChildText("name"));
		}
	}
	
}