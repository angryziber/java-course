package net.azib.java.lessons.net;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.Socket;

public class TCPDemo {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("www.google.com", 80);
		socket.getOutputStream().write("HEAD / HTTP/1.0\r\n\r\n".getBytes());
		IOUtils.copy(socket.getInputStream(), System.out);
		socket.close();
	}
}
