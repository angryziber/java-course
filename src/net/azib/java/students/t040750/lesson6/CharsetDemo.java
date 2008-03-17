package net.azib.java.students.t040750.lesson6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
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
			put("lv", "latviešu");			
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
	
	public static void main(String[] args) throws IOException{
		
		long t = System.currentTimeMillis();
		byte[] b = LANGUAGES.get("lv").getBytes("ISO-8859-13");
		System.out.println(new String(b, "ISO-8859-13"));
		
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
			/*
			 * BufferedReader on hea, sest faili sisu cashitakse buffrisse (niipalju kui buffer mahutab).
			 * Kui hakatakse sealt buffrist ridasid protsessima, siis buffer kustutab loetud read ja lisab 
			 * uued read lõppu. See tõstab programmi performance'it.
			 * */
			String line;
		
			while((line = reader.readLine()) != null) {
				System.out.println(line.length());
			}
		}
		finally {
			if (reader != null) {
				reader.close(); //kui try..finally blokki ei kasuta, siis ei suleta readerit,
								//kui peaks mingi error while tsüklis olema
				System.out.println("Closed");
			}
		}
		
		
		/*
		 * Runnable...uuri järgi mis see on
		 * */
		System.out.println("Passed: " + (System.currentTimeMillis() - t));
	}
}
