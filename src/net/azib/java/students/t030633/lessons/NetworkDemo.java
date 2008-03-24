package net.azib.java.students.t030633.lessons;

import java.io.IOException;
import java.net.InetAddress;

/**
 * NetworkDemo
 * 
 * @author t030633
 */
public class NetworkDemo {
	public static void main(String[] args) throws IOException {

		InetAddress addr = InetAddress.getByName("www.ee");

		System.out.println(addr.getClass());
		System.out.println(addr);
		System.out.println(addr.getAddress().length);
		System.out.println(addr.isReachable(3000));
		
	}

}
