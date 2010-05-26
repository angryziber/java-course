package net.azib.java.students.t093052.homework.action.output;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class represents the csv output action.
 * */
public class CsvOutputAction extends StringOutputAction {
	
	public CsvOutputAction(String filename) throws IOException {
		super(new FileOutputStream(filename));
	}

	@Override
	void append(String value) throws IOException {
		getWriter().write(value + ",");
	}
}
