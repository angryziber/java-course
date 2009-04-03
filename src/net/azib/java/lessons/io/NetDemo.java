package net.azib.java.lessons.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import org.apache.commons.io.IOUtils;

/**
 * NetDemo
 *
 * @author anton
 */
public class NetDemo {
	public static void main(String[] args) throws IOException {
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local.getHostName());
		System.out.println(local.getClass());
		
		InetAddress google = InetAddress.getByName("www.google.com");
		System.out.println(google);
		System.out.println(google.getCanonicalHostName());
		
		Socket s = new Socket();
		s.connect(new InetSocketAddress(google, 80), 2000);
		
		s.getOutputStream().write("GET / HTTP/1.0\r\n\r\n".getBytes());
		new EasyFileCopier().copy(s.getInputStream(), System.out);
		
		s.close();
		
		URL googleUrl = new URL("http://www.google.com/");
		URLConnection urlConn = googleUrl.openConnection();
		System.err.println(urlConn.getClass());
		InputStream urlStream = urlConn.getInputStream();
		IOUtils.copy(urlStream, System.out);
		urlStream.close();
	}
}
