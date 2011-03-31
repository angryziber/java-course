package net.azib.java.students.t093759.hometasks.sixth;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * 30.03.11 21:45
 *
 * @author dionis
 */
public class ContactsTest {
	ContactInformation fooBarsContactInformation;
	ContactInformation homersContactInformation;
	Contacts myContacts = new Contacts();

	@Before
	public void createFriendMocks() {
		fooBarsContactInformation = mock(ContactInformation.class);
//		PersonName fooBarsName = mock(PersonName.class);
//		when(fooBarsName.toString()).thenReturn("Foo Bar");
//		when(fooBarsContactInformation.getPersonName()).thenReturn(fooBarsName);
//		when(fooBarsContactInformation.getPersonName().toString()).thenReturn("Foo Bar");
//		when(fooBarsContactInformation.getPhoneNumber().toString()).thenReturn("123-456");
//		when(fooBarsContactInformation.getBirthday().toString()).thenReturn("1970-12-25");
//		when(fooBarsContactInformation.getEmail().toString()).thenReturn("abc@ksal.com");
//		when(fooBarsContactInformation.equals(fooBarsContactInformation)).thenReturn(true);
//		when(fooBarsContactInformation.equals(homersContactInformation)).thenReturn(false);


		homersContactInformation = mock(ContactInformation.class);
//		when(homersContactInformation.getPersonName().toString()).thenReturn("Kla Ysdkzs");
//		when(homersContactInformation.getPhoneNumber().toString()).thenReturn("2-139-456");
//		when(homersContactInformation.getBirthday().toString()).thenReturn("1971-11-22");
//		when(homersContactInformation.getEmail().toString()).thenReturn("abc@ksal.com");
//		when(homersContactInformation.equals(homersContactInformation)).thenReturn(true);
//		when(homersContactInformation.equals(fooBarsContactInformation)).thenReturn(false);
	}

	@Test
	public void addedContactInformationsAreAvailableAsList() {
		assertThat(myContacts.getContacts().size(), is(0));
		myContacts.add(fooBarsContactInformation);
		myContacts.add(homersContactInformation);

		assertThat(myContacts.getContacts().size(), equalTo(2));
	}

	@Test
	public void duplicateAdditionIsAvailable() {
		assertThat(myContacts.getContacts().size(), is(0));
		myContacts.add(fooBarsContactInformation);
		myContacts.add(homersContactInformation);
		myContacts.add(fooBarsContactInformation);

		assertThat(myContacts.getContacts().size(), equalTo(3));
	}

	@Test
	public void stringRepresentationOfContactsExample() {
		myContacts.add(fooBarsContactInformation);
		myContacts.add(homersContactInformation);


		StringBuilder compoundRepresentation = new StringBuilder("");
		for (ContactInformation contactInformation : myContacts.getContacts()) {
			compoundRepresentation.append(contactInformation.toString() + "\n");
		}
		assertThat(myContacts.toString(), equalTo(compoundRepresentation.toString()));
	}
}
