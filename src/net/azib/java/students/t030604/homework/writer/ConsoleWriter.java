package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataWriter;

import java.util.List;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class ConsoleWriter extends AbstractWriter implements IDataWriter {

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#cleanup()
	 * {@inheritDoc}
	 */
	public void cleanup() {
		//blank
	}
	
	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#output(java.util.List)
	 * {@inheritDoc}
	 */
	public void output(List<AthleteScore> results) {
		for(AthleteScore result : results) {
			System.out.println(result);
		}
	}

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#setup(java.lang.String[])
	 * {@inheritDoc}
	 */
	public void setup(String... args) {
		//blank
	}

}
