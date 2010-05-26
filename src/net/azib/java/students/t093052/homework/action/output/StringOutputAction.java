package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * This class holds the common methods of console and csv output actions
 * */
public abstract class StringOutputAction extends AbstractOutputAction {
	public StringOutputAction(OutputStream stream) throws UnsupportedEncodingException {
		super(stream);
	}

	abstract void append(String value) throws IOException;
	
	@Override
	void append(String placeInterval, Athlete athlete) throws IOException {
		append(placeInterval);
		appendAll(athlete.getMainValues());
		appendAll(athlete.getResults().values().toArray(
				new String[athlete.getResults().size()]));
		getWriter().write(System.getProperty("line.separator"));
	}
	
	private void appendAll(String[] values) throws IOException {
		for (String value : values) {
			append(value);
		}
	}
}
