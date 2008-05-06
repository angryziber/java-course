package net.azib.java.students.t030604.homework.src.main.java.homework;

import net.azib.java.students.t030604.homework.src.main.java.homework.parser.ConsoleParser;

/**
 * Factory pattern to producs DataParsers
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public final class DataParserFactory {
	
	private DataParserFactory() {
		//intended
	}
	
	/**
	 * Initializes the parser
	 * @param parserName
	 * @return
	 */
	public static IDataParser getParser(String parserName) {
		return new ConsoleParser();
	}

}
