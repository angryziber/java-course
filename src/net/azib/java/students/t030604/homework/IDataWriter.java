package net.azib.java.students.t030604.homework;


import net.azib.java.students.t030604.homework.domain.AthleteScore;
import net.azib.java.students.t030604.homework.writer.WriterException;

import java.util.List;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataWriter {
	
	void setup(String... args) throws WriterException;
	
	void cleanup() throws WriterException;
	
	void output(List<AthleteScore> results) throws WriterException;

}
