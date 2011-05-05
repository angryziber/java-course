package net.azib.java.lessons.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleWebServer extends Thread {
	private final Logger LOG = Logger.getLogger(getClass().getName());

	private List<ContentProvider> providerChain = Arrays.asList(
				new HelloWorldProvider(),
				new InsecureFileProvider(),
				new NotFoundProvider()
			);

	public static void main(String[] args) throws IOException, InterruptedException {
		Thread server = new SimpleWebServer();
		server.start();

		Thread.sleep(5000);
		server.interrupt();
	}

	@Override
	public void run() {
		ServerSocket server = null;
		int port = 8080;
		try {
			server = new ServerSocket(port);
			LOG.config("Listening on port " + port);
		}
		catch (IOException e) {
			LOG.severe("Failed to listen to port " + port);
			return;
		}

		while (!Thread.interrupted()) {
			Socket client = null;
			try {
				client = server.accept();
				LOG.info("Accepted connection from " + client.getRemoteSocketAddress());
				handle(client);
				client.close();
			}
			catch (Exception e) {
				LOG.log(Level.WARNING, "Request handling failed from " + client, e);
			}
		}

		try {
			server.close();
		}
		catch (IOException e) {
		}
		LOG.info("Server terminated");
	}

	void handle(Socket client) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "US-ASCII"));
		String request = reader.readLine();
		String fileName = request.replaceFirst("GET (.*?) HTTP/.*", "$1");
		fileName = URLDecoder.decode(fileName, "UTF-8");

		while (!"".equals(reader.readLine()));
		PrintStream out = new PrintStream(client.getOutputStream());
		out.print("HTTP/1.1 200 OK\r\n");
		out.print("Content-Type: text/html; charset=UTF-8\r\n");
		out.print("\r\n");

		for (ContentProvider provider : providerChain) {
			if (provider.provide(fileName, out))
				break;
		}
	}
}
