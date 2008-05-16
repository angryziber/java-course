package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.IDataWriter;
import net.azib.java.students.t030604.homework.domain.AthleteScore;

import java.util.List;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class ConsoleWriter extends AbstractWriter implements IDataWriter {

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#cleanup()
	 */
	public void cleanup() {
		//blank
	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#output(java.util.List)
	 */
	public void output(List<AthleteScore> results) {
		for(AthleteScore result : results) {
			System.out.println(result);
		}
	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#setup()
	 */
	public void setup(String... args) {
		//blank
	}

}
