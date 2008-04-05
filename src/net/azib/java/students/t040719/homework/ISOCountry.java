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
 * Country
 *
 * @author romi
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
	
	public static boolean isValidCountryCode(String isoCode){
		return ISOCountry.countries.containsKey(isoCode);
	}
	
	public static String getCountryName(String isoCode){
		if (ISOCountry.isValidCountryCode(isoCode))
			return ISOCountry.countries.get(isoCode);
		else
			return "";
	}
	
	@SuppressWarnings("unchecked")
	private static void loadCountries() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(Athlete.class.getResourceAsStream("countries.xml"));
		
		List<Element> children = doc.getRootElement().getChildren("country");
		for (Element country : children) {
			ISOCountry.countries.put(country.getChildText("code"), country.getChildText("name"));
		}
	}
	
}