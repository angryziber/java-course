package net.azib.java.students.t030604.homework.src.main.java.homework;

import net.azib.java.students.t030604.homework.src.main.java.homework.domain.PlayerScore;

import java.util.List;


/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataWriter {
	
	void setup();
	
	void cleanup();
	
	void output(List<PlayerScore> results);

}
