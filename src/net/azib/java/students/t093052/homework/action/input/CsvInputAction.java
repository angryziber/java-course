package net.azib.java.students.t093052.homework.action.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This class represents the csv input action.
 * */
public class CsvInputAction extends AbstractInputStreamAction {
	private String fileName;

	public CsvInputAction(String fileName) {
		this.fileName = fileName;
	}

	@Override
	InputStream getInputStream() throws IOException {
		return new FileInputStream(fileName);
	}

	@Override
	String nextLine(Scanner scanner) {
		if (scanner.hasNextLine()) {
			return scanner.nextLine();
		}
		return null;
	}

}
