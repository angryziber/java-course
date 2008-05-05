package main.java.homework;

import java.util.List;

import main.java.homework.domain.PlayerScore;

/**
 * Launches the whole thing
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class Launcher {
	
	/**
	 * main method
	 * @param args
	 */
	public static void main (String[] args) {
		if (args == null || args.length != 2) {
			System.out.println("usage java -jar jar_name input output");
			System.out.println("where input = [manual | csv | mysql]");
			System.out.println("and output =  [console | csv | xml | html]");
			System.exit(1);
		}
		
		IDataParser parser = DataParserFactory.getParser(args[0]);
		parser.setup(args);
		List<PlayerScore> records = parser.parseData();
		parser.cleanup();
		records = DataProcessor.process(records);
		IDataWriter output = DataWriterFactory.getWriter(args[1]);
		output.setup();
		output.output(records);
		output.cleanup();
	}

}
