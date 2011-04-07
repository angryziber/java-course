package net.azib.java.lessons.net;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLDemo {
	public static void main(String[] args) throws IOException, URISyntaxException {
		URL url = new URL("https://www.google.com/adsense");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getFile());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		System.out.println(conn.getClass());
		System.out.println(conn.getContentType());
		System.out.println(conn.getHeaderField("Server"));
		IOUtils.copy(conn.getInputStream(), System.out);

		URL url2 = new URL("http://somehost/hello%20world/a/..");
		URI uri2 = url2.toURI();
		System.out.println(url2.getFile());
		System.out.println(uri2.getPath());
	}
}
