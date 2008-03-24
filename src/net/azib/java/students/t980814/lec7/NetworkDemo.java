package net.azib.java.students.t980814.lec7;

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
		
		addr = InetAddress.getByName("193.40.254.179");
		System.out.println(addr);
		
		addr = InetAddress.getLocalHost();
		System.out.println(addr);
	}
	
}
