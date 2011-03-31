package net.azib.java.students.t093759.hometasks.sixth;

/**
 * 30.03.11 22:07
 *
 * @author dionis
 */
public class ContactInformation {


	private PersonName personName;
	private PhoneNumber phoneNumber;
	private Email email;
	private Birthday birthday;

	public ContactInformation(PersonName personName, PhoneNumber phoneNumber, Email email, Birthday birthday) {
		if (personName == null || phoneNumber == null || email == null || birthday == null) {
			throw new IllegalArgumentException(getClass().getSimpleName() + ": All fields required.");
		}
		this.personName = personName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;

	}


	public PersonName getPersonName() {
		return personName;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public Email getEmail() {
		return email;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ContactInformation that = (ContactInformation) o;

		if (!birthday.equals(that.birthday)) return false;
		if (!email.equals(that.email)) return false;
		if (!personName.equals(that.personName)) return false;
		if (!phoneNumber.equals(that.phoneNumber)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = personName.hashCode();
		result = 31 * result + phoneNumber.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + birthday.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return String.format("Name:%35s\nPhone:%34s\nEmail:%34s\nBirthday:%31s",
				personName.toString(), phoneNumber.toString(), email.toString(), birthday.toString());
	}
}
