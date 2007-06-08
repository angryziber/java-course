package net.azib.java.students.t060401.homework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * LanguageUtil
 * 
 * Loads language resource for specified language and provides methods for getting language strings for specified keys and languages
 * 
 * @author t060401
 */
public class LanguageUtil {

	private static Logger log = Logger.getLogger(LanguageUtil.class.getName());
	private static String DEFAULT_LANGUAGE = "EN";
	private static HashMap<String, ResourceBundle> bundles;

	static {
		// Holds all the language keys and corresponding resources
		bundles = new HashMap<String, ResourceBundle>();

		InputStream stream = LanguageUtil.class.getResourceAsStream("resource_"+new Locale("en")+".properties");
		if (stream != null) {
			try {
				bundles.put(DEFAULT_LANGUAGE, new PropertyResourceBundle(stream));
			}
			catch (IOException e) {
				log.log(Level.SEVERE, "Resource missing "+ e);
			}
		}

	}

	/**
	 * @param code
	 *            code for which to retrieve the value from the ResourceBundle.
	 * @return returns value for the given code in default language
	 */
	public static String getString(String code) {
		return getString(DEFAULT_LANGUAGE, code);
	}

	/**
	 * @param language
	 * @param code
	 *            code for which to retrieve the value from the ResourceBundle.
	 * @return returns value for the given code in given language
	 */
	public static String getString(String language, String code) {
		String value = "";
		// Get the resource bundle for the given language.
		PropertyResourceBundle bundle = (PropertyResourceBundle) bundles.get(language);
		if (bundle != null) {
			try {
				// Get the language string from the bundle
				value = bundle.getString(code);
			}
			catch (Exception e) {
				log.log(Level.SEVERE, "Resource missing for the key: " + code + ". " + e);
			}
		}
		else {
			log.log(Level.SEVERE, "Could not find resource for language " + language);
		}
		return value;
	}
}
