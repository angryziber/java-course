package net.azib.java.students.t050657.Home;

import net.azib.java.lessons.net.EchoRequestHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * FileRequestHandler
 *
 * @author Boriss
 */

public class FileRequestHandler extends EchoRequestHandler {
	
	private static final String MAIN_SERVER_FOLDER = "C:\\Server\\";

	public void writeResponse() {
		if(requestPath.equals("/")) {
			writeResponse();
		}
		else {

			BufferedReader reader = null;
			PrintWriter writer = null;
			
			try {
				writer = new PrintWriter(
						new OutputStreamWriter(socket.getOutputStream(), ENCODING));
				reader = new BufferedReader(
							new FileReader(getFile(requestPath)));
				
				while(reader.ready()) {
					writer.println(reader.readLine());
				}
			}
			catch(FileNotFoundException e) {
				writer.println("404. File not found 8((");
			}
			catch(IOException e) {
				System.out.println("Cannot get output stream, what to do?");
			}
			finally {
				try {
					reader.close();
				}catch (IOException e) {
					// this should not happen
				}catch (NullPointerException e) {
					// 404. File not found on server 8((
					writer.println("404. File not found 8((!!!!!");
				}
				writer.flush();
			}
		}			
	}

	private File getFile(String requestPath) {
		File requestedFile = new File(MAIN_SERVER_FOLDER, requestPath);
		return requestedFile;
	}
}