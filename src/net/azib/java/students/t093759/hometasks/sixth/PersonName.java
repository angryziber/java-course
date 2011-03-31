package net.azib.java.students.t093759.hometasks.sixth;

/**
 * 30.03.11 22:48
 *
 * @author dionis
 */
public class PersonName {

	private String name;

	public PersonName(String name) {
		if (!isValid(name)) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": Name can consist only from characters and whitespaces between characters");
		}
		this.name = name;
	}

	public static boolean isValid(String name) {
		return name.matches("^([a-zA-Z]+[ ]?){1,}[a-zA-Z]$");
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
