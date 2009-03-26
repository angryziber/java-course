package net.azib.java.lessons.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * CharsetDemo
 *
 * @author anton
 */
public class Languages {
	public static final Map<String, String> LANGUAGES = new HashMap<String, String>() {
		{
			put("en", "english");
			put("et", "eesti");
			put("lv", "latviešu");			
			put("fr", "français");
			put("es", "español");
			put("ru", "русский");
			put("tr", "türkçe");			
			put("hy", "հայերեն լեզու");
			put("he", "עברית");
			put("hi", "हिन्दी");
			put("zh", "中文");
			put("ja", "日本語");			
			put("ti", "ትግርኛ");
			put("ar", "الْعَرَبيّة");			
		}
	};
	
	public static void main(String[] args) throws IOException {
		byte[] b = LANGUAGES.get("lv").getBytes();
		System.out.println(new String(b));
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(".classpath"), "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				System.out.println(line.length());
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Sorry, file not found");
		}
		catch (IOException e) {
			System.out.println("reading failed: " + e.getMessage());
		}
		finally {
			if (reader != null) {
				reader.close();
				System.out.println("closed!!!");
			}
		}
	}
}
