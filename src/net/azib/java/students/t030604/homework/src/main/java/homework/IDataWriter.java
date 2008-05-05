package main.java.homework;

import java.util.List;

import main.java.homework.domain.PlayerScore;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public interface IDataWriter {
	
	void setup();
	
	void cleanup();
	
	void output(List<PlayerScore> results);

}
