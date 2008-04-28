package net.azib.java.students.t072054.hometask1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * NetworkDemo
 *
 * @author dell
 */
public class NetworkDemo {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr = InetAddress.getByName("www.ee");
		System.out.println(addr);
		
		addr = InetAddress.getByName("10.0.0.255");
		System.out.println(addr);
		
		addr = InetAddress.getLocalHost();
		System.out.println(addr);
	}
	
}
