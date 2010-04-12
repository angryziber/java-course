package net.azib.java.lessons.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

/**
 * NetworkDemo
 *
 * @author anton
 */
public class NetworkDemo {
	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName("www.ee");
		System.out.println(address);
		System.out.println(address.getCanonicalHostName());
		System.out.println("ping: " + address.isReachable(3000));
		
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println(localhost);
		System.out.println("ping: " + localhost.isReachable(3000));
		
		InetSocketAddress socketAddress = new InetSocketAddress(address, 80);
		
		Socket s = new Socket();
		s.connect(socketAddress, 2000);
		
		s.getOutputStream().write("GET / HTTP/1.0\r\nHost: www.ee\r\n\r\n".getBytes());
		IOUtils.copy(s.getInputStream(), System.out);
		s.close();
	}
}
