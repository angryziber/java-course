package net.azib.java.lessons.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * WebServerTest
 *
 * @author anton
 */
public class WebServerCheck {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://localhost:8080/");
		URLConnection conn = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}
}
