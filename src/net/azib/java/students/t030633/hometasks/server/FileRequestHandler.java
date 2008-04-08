package net.azib.java.students.t030633.hometasks.server;

import net.azib.java.students.t030633.hometasks.copier.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

/**
 * FileRequestHandler
 * 
 * @author t030633
 */
public class FileRequestHandler extends AbstractRequestHandler {

	private static final String HTTP_404 = "HTTP 404 Not Found";

	public FileRequestHandler(Socket s) {
		super(s);
	}

	public void handleRequest(InputStream in, OutputStream out) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		if (st.nextToken().compareTo("GET") == 0) {

			try {
				URI fileURI = new URI(st.nextToken());
				URI dirURI = FileRequestHandler.class.getResource(".").toURI();
				File file = new File(dirURI.getPath() + fileURI.getPath());
				if (!file.exists())
					notFound(out);
				else {
					FileInputStream fis = new FileInputStream(file);
					new DirectChanneledCopyProgram(capacity).copy(fis, out);
				}
			}
			catch (URISyntaxException e1) {
				notFound(out);
			}

		}

	}

	private void notFound(OutputStream out) throws IOException {
		out.write((HTTP_404).getBytes());
	}

}
