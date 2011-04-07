package net.azib.java.lessons.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		printAddress(InetAddress.getLocalHost());
		printAddress(InetAddress.getByName("www.google.com"));
		printAddress(InetAddress.getByName("fe80::1e4b:d6ff:fe60:f8e1"));

		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface iface = interfaces.nextElement();
			System.out.println(iface);
		}
	}

	private static void printAddress(InetAddress address) {
		System.out.println(address.getClass());
		System.out.println(Arrays.toString(address.getAddress()));
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println(address.getCanonicalHostName());
	}
}
