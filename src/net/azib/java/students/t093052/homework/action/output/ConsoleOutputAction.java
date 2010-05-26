package net.azib.java.students.t093052.homework.action.output;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * This class represents the console output action.
 * */
public class ConsoleOutputAction extends StringOutputAction {
	private static final String EMPTY_SPACE = 
		"                                             ";
	
	public ConsoleOutputAction() throws UnsupportedEncodingException {
		super(System.out);
	}
	
	@Override
	void append(String value) throws IOException {
		getWriter().write(EMPTY_SPACE.substring(value.length()) + value + " ");
	}
}
