package net.azib.java.students.t030520.homework.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Command
 *
 * @author t030520
 */
public enum Command {

	CONSOLE("-console", null, true, true),
	CSV("-csv", "[\\a-zA-Z0-9/]+(.csv)", true, true),
	DB("-db", "[0-9a-zA-Z]+", true, false),
	XML("-xml", "[\\a-zA-Z0-9/]+(.xml)", false, true),
	HTML("-html", "[\\a-zA-Z0-9/]+(.html)", false, true);

	private String command;
	private Pattern pattern;
	private boolean input;
	private boolean output;

	private Command(String command, String pattern, boolean input, boolean output) {
		this.command = command;
		this.pattern = pattern == null ? null : Pattern.compile(pattern);
		this.input = input;
		this.output = output;
	}

	/**
	 * @return the pattern for the parameters entered. 
	 */
	public Pattern getPattern() {
		return this.pattern;
	}

	/**
	 * @return the command.
	 */
	public String valueOf() {
		return this.command;
	}

	/**
	 * @return true if the command is input command.
	 */
	public boolean isInput() {
		return this.input;
	}

	/**
	 * @return true if the command is output command.
	 */
	public boolean isOutput() {
		return this.output;
	}

	/**
	 * @param command the controlled command
	 * @return true if the command matches the pattern.
	 */
	public boolean matches(String command) {
		Matcher m = this.getPattern().matcher(command);
		return m.matches();
	}

	/**
	 * @param command
	 * @return true if the commands are equal.
	 */
	public boolean equals(String command) {
		return command != null && valueOf().equals(command.toLowerCase());
	}
}
