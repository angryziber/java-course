package net.azib.java.students.t093052.homework.action.output;

import java.io.IOException;
import java.io.OutputStreamWriter;


/**
 * This class represents the console output action.
 * */
public class ConsoleOutputAction extends AbstractOutputAction {
	private static final String EMPTY_SPACE = 
		"                                             ";
	
	public ConsoleOutputAction() {
		super(new OutputStreamWriter(System.out));
	}
	
	void append(String value) throws IOException {
		getWriter().write(EMPTY_SPACE.substring(value.length()) + value + " ");
	}
}
