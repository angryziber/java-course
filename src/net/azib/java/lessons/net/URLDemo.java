package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

/**
 * URLDemo
 *
 * @author anton
 */
public class URLDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.ee/");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		
		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		InputStream stream = urlConn.getInputStream();
		IOUtils.copy(stream, System.out);
		stream.close();
	}
}
