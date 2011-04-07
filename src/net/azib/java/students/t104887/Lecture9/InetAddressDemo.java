package net.azib.java.students.t104887.Lecture9;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		printAddress(InetAddress.getLocalHost());
		printAddress(InetAddress.getByName("www.google.com"));
		printAddress(InetAddress.getByAddress("127.0.0.1", new byte[]{127, 0, 0, 1}));
		printAddress(InetAddress.getByName("localhost"));

		Enumeration<NetworkInterface> infs = NetworkInterface.getNetworkInterfaces();
		while (infs.hasMoreElements()) {
			NetworkInterface inf = infs.nextElement();
			System.out.println("Name : " + inf.getName());
			Enumeration<InetAddress> addrs = inf.getInetAddresses();
			while (addrs.hasMoreElements()) {
				System.out.println("  " + addrs.nextElement().getHostAddress());
			}
		}
	}

	private static void printAddress(InetAddress address) {
		System.out.println(Arrays.toString(address.getAddress()));
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println(address.getCanonicalHostName());
	}
}
