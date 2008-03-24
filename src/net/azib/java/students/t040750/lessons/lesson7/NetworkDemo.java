package net.azib.java.students.t040750.lessons.lesson7;

import java.io.IOException;
import java.net.InetAddress;

/**
 * NetworkDemo
 *
 * @author t040750
 */
public class NetworkDemo {
	public static void main(String[] args) throws IOException{
		InetAddress addr = InetAddress.getByName("www.ee");
		System.out.println(addr.getClass());
		System.out.println(addr);
		System.out.println(addr.isReachable(3000));
		System.out.println(InetAddress.getLocalHost().isReachable(3000));
		System.out.println(addr.getAddress().length);
		System.out.println(addr.getHostName());
		addr = InetAddress.getByName("192.204.33.19");
		System.out.println(addr); 	//kuvab aint ip aadressi, kuna hostname küsimine
									//on kulukas protsess. 
		System.out.println(addr.getHostName());
	}
}
