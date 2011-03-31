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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Email email1 = (Email) o;

		if (!email.equals(email1.email)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return email.hashCode();
	}

	@Override
	public String toString() {
		return email;
	}
}
