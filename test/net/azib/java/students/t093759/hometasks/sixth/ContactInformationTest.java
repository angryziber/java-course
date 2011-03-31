package net.azib.java.students.t093759.hometasks.sixth;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 30.03.11 22:09
 *
 * @author dionis
 */
public class ContactInformationTest {
	private PersonName personName;
	private PhoneNumber phoneNumber;
	private Email email;
	private Birthday birthday;

	@Before
	public void mockContactInfoObjects() {
		personName = mock(PersonName.class);
		when(personName.getName()).thenReturn("Homer Simpson");
		when(personName.toString()).thenReturn("Homer Simpson");

		phoneNumber = mock(PhoneNumber.class);
		when(phoneNumber.getFormattedPhoneNumber()).thenReturn("1-200-600");
		when(phoneNumber.toString()).thenReturn("1-200-600");

		email = mock(Email.class);
		when(email.getEmail()).thenReturn("homer.simpson@springfield.com");
		when(email.toString()).thenReturn("homer.simpson@springfield.com");

		birthday = mock(Birthday.class);
		when(birthday.getFormattedBirthdayDate()).thenReturn("1970-12-25");
		when(birthday.toString()).thenReturn("1970-12-25");
	}

	@Test(expected = IllegalArgumentException.class)
	public void allFieldsRequiredForContactInformationCreation() {
		new ContactInformation(personName, null, email, null);
	}

	@Test
	public void ContactInformationRemembersAllGivenInformation() {
		ContactInformation contactInformation = new ContactInformation(personName, phoneNumber, email, birthday);
		assertThat(contactInformation.getPersonName(), equalTo(personName));
		assertThat(contactInformation.getPhoneNumber(), equalTo(phoneNumber));
		assertThat(contactInformation.getEmail(), equalTo(email));
		assertThat(contactInformation.getBirthday(), equalTo(birthday));
	}

	@Test
	public void stringRepresentationExample() {
		String expectedStringRepresentation = String.format("Name:%35s\nPhone:%34s\nEmail:%34s\nBirthday:%31s",
				personName.toString(), phoneNumber.toString(), email.toString(), birthday.toString());
		assertThat(new ContactInformation(personName, phoneNumber, email, birthday).toString(),
				equalTo(expectedStringRepresentation));
	}

	@Test
	public void twoContactInformationWithTheSameDataAreEqual() {
		assertThat(new ContactInformation(personName, phoneNumber, email, birthday),
				equalTo(new ContactInformation(personName, phoneNumber, email, birthday)));
	}
}
