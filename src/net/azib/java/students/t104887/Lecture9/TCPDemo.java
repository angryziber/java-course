package net.azib.java.students.t104887.Lecture9;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class TCPDemo {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("www.google.com", 80);
		socket.getOutputStream().write("HEAD / HTTP/1.0\r\n\r\n".getBytes());
		IOUtils.copy(socket.getInputStream(),System.out);
		socket.close();
	}
}
