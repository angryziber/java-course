package net.azib.java.lessons.io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

/**
 * ServerDemo
 *
 * @author anton
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		
		System.err.println("Accepting connections on port 8080");
		Socket client = server.accept();
		
		readAndDisplayRequest(client);
				
		client.getOutputStream().write((
				"HTTP/1.0 200 OK\r\n" +
				"Content-type: text/html; charset=UTF-8\r\n\r\n" +
				"<h1>Simple Web Server Works!!! öä йф</h1>").getBytes("UTF-8"));
		
		client.close();
		server.close();
	}

	private static void readAndDisplayRequest(Socket client) throws IOException {
		LineIterator i = IOUtils.lineIterator(new InputStreamReader(client.getInputStream()));
		while (i.hasNext()) {
			String s = i.nextLine();
			if (s.isEmpty()) {
				break;
			}
			System.out.println(s);
		}
		System.err.println("End of request");
	}
}
