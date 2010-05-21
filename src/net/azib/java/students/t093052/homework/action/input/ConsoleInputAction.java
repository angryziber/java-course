package net.azib.java.students.t093052.homework.action.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This class represents the console input action.
 * */
public class ConsoleInputAction extends AbstractInputStreamAction {

	@Override
	InputStream getInputStream() throws IOException {
		System.out.println("Insert competitors or type \"ENTER\" to exit...");
		return System.in;
	}
	
	@Override
	String nextLine(Scanner scanner) {
		String line = null;
		do {
			line = scanner.nextLine();

			if ("".equals(line)) {
				return null;
			}
			
			if (isLineValid(line)) {
				return line;
			}
			
			System.out.println("Line is invalid...");
		} while(true);
	}

	private boolean isLineValid(String line) {
		return line.matches("\".*\",\\s*\\d{1,2}\\.\\d{1,2}\\.\\d{4}," +
			"\\s*[A-Za-z]{2}(,\\s*(\\d+:\\d+)?\\d+\\.\\d+\\s*){10}");
	}
}
