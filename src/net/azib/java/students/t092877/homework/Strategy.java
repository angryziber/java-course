package net.azib.java.students.t092877.homework;

public interface Strategy {

	public static final String CONSOLE = "-console";
	public static final String CSV_FILE = "-csv";
	public static final String INPUT_FROM_DATABASE = "-db";
	public static final String OUTPUT_TO_XML = "-xml";
	public static final String OUTPUT_TO_HTML = "-html";

	void execute(Competition competition);

}
