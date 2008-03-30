package net.azib.java.lessons.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * NetworkDemo
 *
 * @author anton
 */
public class NetworkDemo {
	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName("www.ee");
		System.out.println(addr.getClass());
		System.out.println(addr);
		System.out.println(InetAddress.getLocalHost().isReachable(3000));
		System.out.println(addr.getAddress().length);
		
		addr = InetAddress.getByName("194.204.33.19");
		System.out.println(addr);
		System.out.println(addr.getHostName());
		System.out.println(addr);
	}
}








