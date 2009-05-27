package net.azib.java.students.t030520.homework.command;

import java.util.regex.Pattern;

/**
 * The enum provides the possible input commands.
 *
 * @author t030520
 */
public enum InputCommand {

	CONSOLE("-console", null),
	CSV("-csv", "[\\a-zA-Z0-9/]+(.csv)"),
	DB("-db", "[0-9a-zA-Z]+");

	private String command;
	private Pattern pattern;

	private InputCommand(String command, String pattern) {
		this.command = command;
		this.pattern = pattern == null ? null : Pattern.compile(pattern);
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
	 * @param command
	 * @return true if the commands are equal.
	 */
	public boolean equals(String command) {
		return command != null && valueOf().equals(command.toLowerCase());
	}
}
