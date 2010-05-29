package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

/**
 * This class represents the common methods of all output actions
 * */
public abstract class AbstractOutputAction implements OutputAction {
	private Writer writer;
	
	abstract void append(String placeInterval, Athlete athlete) throws IOException;
	
	public AbstractOutputAction(
			OutputStream stream) throws UnsupportedEncodingException {
		this.writer = new BufferedWriter(new OutputStreamWriter(stream, "UTF-8"));
	}
	
	Writer getWriter() {
		return writer;
	}

	@Override
	public void addToOutput(String placeInterval, 
			List<Athlete> athletes) throws IOException {
		for (Athlete athlete : athletes) {
			append(placeInterval, athlete);
		}
	}
	
	@Override
	public void finishOutput() throws IOException {
		getWriter().close();
	}
}
