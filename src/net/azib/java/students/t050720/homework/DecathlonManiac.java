package net.azib.java.students.t050720.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * DecathlonManiac
 *
 * @author Marek
 */
public class DecathlonManiac {

	public static void main(String [] args) throws Exception
	{
		InputFactory inputHandler = new InputFactory();
		
		ArgumentsParser commander= new ArgumentsParser(args);
		
		Input inputObj = inputHandler.getInputPlugin(commander.inputType(), commander.inputParams());
		
		ArrayList<Record> records = new ArrayList<Record>();
		
		try {
			inputObj.readInto(records);
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Collections.sort(records);
		
		OutputFactory outputHandler = new OutputFactory();
		Output outputObj = outputHandler.getOutputPlugin(commander.outputType(), commander.outputParams());
		
		outputObj.flush(records);
	}
}
