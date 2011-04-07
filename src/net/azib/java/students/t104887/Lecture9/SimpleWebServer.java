package net.azib.java.students.t104887.Lecture9;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 7.04.11
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class SimpleWebServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8081);
		while (true) {
			Socket client = server.accept();
			handle(client);
			client.close();
		}
	}

	private static void handle(Socket client) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "US-ASCII"));
		String request = reader.readLine();
		String filename = request.replaceFirst("GET (.*?) HTTP/.*", "$1");
		while ("".equals(reader.readLine())) ;
		PrintStream out = new PrintStream(client.getOutputStream());
		out.print("HTTP/1.0 OK\r\n\r\n");
		out.print("Content-Type: text/html\r\n\r\n");
		out.print("\r\n\r\n");

		if (!serve(filename, client.getOutputStream())) {
			out.print("<h1>" + filename + " not found!</h1>\r\n\r\n");
		}
	}

	private static boolean serve(String filename, OutputStream out) throws IOException {
		File file = new File("temp");
		if (!file.exists()) return false;

		FileInputStream in = new FileInputStream(file);
		IOUtils.copy(in,out);
		in.close();
		return true;
	}
}
