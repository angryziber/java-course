package net.azib.java.students.t040719;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * NetworkDemo
 *
 * @author t040719
 */
public class NetworkDemo {
	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName("www.ee");
		System.out.println(addr.isReachable(3000));
		System.out.println(addr.getAddress().length);
	}
}
