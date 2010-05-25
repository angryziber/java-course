package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public abstract class AbstractOutputAction implements OutputAction {
	private Writer writer;
	
	abstract void append(String value) throws IOException;
	
	public AbstractOutputAction(Writer writer) {
		this.writer = writer;
	}
	
	Writer getWriter() {
		return writer;
	}

	@Override
	public void addToOutput(String placeInterval, List<Athlete> athletes) throws Exception {
		for (Athlete athlete : athletes) {
			append(placeInterval);
			appendAll(athlete.getMainValues());
			appendAll(athlete.getResults().values().toArray(
					new String[athlete.getResults().size()]));
			getWriter().write(System.getProperty("line.separator"));
		}
	}
	
	private void appendAll(String[] values) throws IOException {
		for (String value : values) {
			append(value);
		}
	}
	
	@Override
	public void finishOutput() throws Exception {
		getWriter().close();
	}
}
