package net.azib.java.students.t093052.homework.action.output;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the csv output action.
 * */
public class CsvOutputAction extends AbstractOutputAction {
	
	public CsvOutputAction(String filename) throws IOException {
		super(new FileWriter(filename));
	}

	@Override
	void append(String value) throws IOException {
		getWriter().write(value + ",");
	}
}
