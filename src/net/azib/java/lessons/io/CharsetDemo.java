package net.azib.java.lessons.io;

import java.util.HashMap;
import java.util.Map;

/**
 * CharsetDemo
 *
 * @author anton
 */
public class CharsetDemo {
	public static final Map<String, String> LANGUAGES = new HashMap<String, String>() {
		{
			put("en", "english");
			put("et", "eesti");
			put("et", "latviešu");			
			put("fr", "français");
			put("es", "español");
			put("ru", "русский");
			put("tr", "Türkçe");			
			put("hy", "հայերեն լեզու");
			put("he", "עברית");
			put("hi", "हिन्दी");
			put("zh", "中文");
			put("ja", "日本語");			
			put("ti", "ትግርኛ");
			put("ar", "الْعَرَبيّة");			
		}
	};
}
