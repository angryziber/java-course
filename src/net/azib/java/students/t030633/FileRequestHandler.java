package net.azib.java.students.t030633;

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

	/** _404_NOT_FOUND */
	private static final String NOT_FOUND = "404 Not Found";

	public FileRequestHandler(Socket s) {
		super(s);
	}

	public static final String HTTP_LN = "\r\n";
	public static final String HTTP = "HTTP";
	public static final String HTTP_OK_RESPONSE = HTTP + " 200 OK";
	public static final String HTTP_NOT_FOUNT = HTTP + " 404 Not Found";

	public void handleRequest(InputStream in, OutputStream out) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		if (st.nextToken().compareTo("GET") == 0) {

			URI fileURI;
			URI dirURI;
			FileInputStream fis;
			File file;
			
			try {
				
				fileURI = new URI(st.nextToken());
				dirURI = FileRequestHandler.class.getResource(".").toURI();
				file = new File(dirURI.getPath() + fileURI.getPath());
				if (!file.exists())
					out.write((NOT_FOUND).getBytes());
				else {
					
					fis = new FileInputStream(file);
					
					// capacity = socket send buffer size
					byte[] dataBuffer = new byte[capacity]; 
					
					int bytes = 0; // how much data is in the buffer
					
					// while there is data to read
					while ((bytes = fis.read(dataBuffer)) > 0) 
					{
						// write from buffer to output
						out.write(dataBuffer, 0, bytes); 
					}
					
					fis.close();
					
				}
				
			}
			catch (URISyntaxException e1) {
				out.write((NOT_FOUND).getBytes());
			}

		}

	}

}
