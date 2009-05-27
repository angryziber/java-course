package net.azib.java.students.t030520.homework.command;

import java.util.regex.Pattern;

/**
 * The enum provides the possible output commands.
 *
 * @author t030520
 */
public enum OutputCommand {

	CONSOLE("-console", null),
	CSV("-csv", "[\\a-zA-Z0-9/]+(.csv)"),
	XML("-xml", "[\\a-zA-Z0-9/]+(.xml)"),
	HTML("-html", "[\\a-zA-Z0-9/]+(.html)");

	private String command;
	private Pattern pattern;

	private OutputCommand(String command, String pattern) {
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
