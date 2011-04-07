package net.azib.java.students.t104887.Lecture9;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public class URLDemo {
	public static void main(String[] args) throws IOException, URISyntaxException{
		URL url = new URL("https://www.google.com/adsence");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getFile());

		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		System.out.println(conn.getClass());
		System.out.println(conn.getContent());
		System.out.println(conn.getDate());

		URL url2 = new URL("http://somehost/hello%20world/a/..");
		URI uri2 = url2.toURI();
		System.out.println(url2.getFile());
		System.out.println(uri2.getPath());

	}
}
