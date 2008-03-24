package net.azib.java.lessons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * FileContentDownloader
 *
 * @author anton
 */
public class FileContentDownloader {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.ee/");
		URLConnection urlConnection = url.openConnection();
		urlConnection.setReadTimeout(2000);
		InputStream stream = urlConnection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
		System.err.println(urlConnection.getClass());
	}
}
