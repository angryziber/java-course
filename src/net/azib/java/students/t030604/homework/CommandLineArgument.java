package net.azib.java.students.t030604.homework;

import net.azib.java.students.t030604.homework.parser.ConsoleParser;
import net.azib.java.students.t030604.homework.parser.CsvParser;
import net.azib.java.students.t030604.homework.parser.DbParser;
import net.azib.java.students.t030604.homework.writer.ConsoleWriter;
import net.azib.java.students.t030604.homework.writer.CsvWriter;
import net.azib.java.students.t030604.homework.writer.HtmlWriter;
import net.azib.java.students.t030604.homework.writer.XmlWriter;

/**
 * defines possible command line arguments
 * @author Aleksandr Ivanov
 * <a href="mailto:aleksandr.ivanov@tietoenator.com">contact</a>
 */
public enum CommandLineArgument {
	
	CONSOLE("-console", false, ConsoleParser.class, ConsoleWriter.class),
	CSV("-csv", true, CsvParser.class, CsvWriter.class),
	DB("-db", true, DbParser.class, null),
	XML("-xml", true, null, XmlWriter.class),
	HTML ("-html", true, null, HtmlWriter.class);
	
	private Class<? extends IDataParser> parser; // parser implementation class
	private Class<? extends IDataWriter> writer; // writer implementation class
	private String name; // argument
	private boolean mustHaveParam; // is parameter presence mandatory or not
	
	private CommandLineArgument(
			String name,
			boolean mustHaveParam,
			Class<? extends IDataParser> parser,
			Class<? extends IDataWriter> writer){
		this.name  = name;
		this.mustHaveParam = mustHaveParam;
		this.parser = parser;
		this.writer = writer;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the mustHaveParam
	 */
	public boolean isMustHaveParam() {
		return mustHaveParam;
	}

	/**
	 * @return the parser
	 */
	public Class<? extends IDataParser> getParser() {
		return parser;
	}

	/**
	 * @return the writer
	 */
	public Class<? extends IDataWriter> getWriter() {
		return writer;
	}
	
	
	
}
