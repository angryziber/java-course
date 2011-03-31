package net.azib.java.students.t093759.hometasks.sixth;

/**
 * 31.03.11 0:41
 *
 * @author dionis
 */
public class Email {
	private String email;

	public Email(String email) {
		if (!isValid(email)) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": You entered incorrect email.");
		}
		this.email = email;
	}

	public static boolean isValid(String email) {
		return email.matches("^([a-z0-9-][.]?)*[a-z0-9-]@([a-z0-9-][.]?)*[a-z0-9-][.][a-z]{2,5}$");
	}

	public String getEmail() {
		return email;
	}
}
