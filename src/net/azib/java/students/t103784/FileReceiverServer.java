package net.azib.java.students.t103784;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ott
 * Date: 7.04.11
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class FileReceiverServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		new FileReceiverServer().start();
	}

	public void start() throws IOException, InterruptedException {
		ServerSocket server = new ServerSocket(8080);
		while (true) {
			Socket client = server.accept();
			System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
			handle(client);
			client.close();
		}
	}

	void handle(Socket client) throws IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "US-ASCII"));
		String request = reader.readLine();
		String fileName = request.replaceFirst("GET (.*?) HTTP/.*", "$1");
		fileName = URLDecoder.decode(fileName, "UTF-8");

		while (!"".equals(reader.readLine()));
		PrintStream out = new PrintStream(client.getOutputStream());
		out.print("HTTP/1.1 200 OK\r\n");
		out.print("Content-Type: text/html; charset=UTF-8\r\n");
		out.print("\r\n");

	}
}
