package net.azib.java.students.t104971.chars;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;


/**
 * @author Jaroslav Judin
 */
public class ContactsTest {

    @Test
    public void testBuildContactsList() throws Exception {
        Contacts contacts = new Contacts();

        PersonBuilder builder = mock(PersonBuilder.class);
        contacts.setPersonBuilder(builder);
        when(builder.createPerson()).thenReturn(new Person());

        ConsoleInput console = mock(ConsoleInput.class);
        contacts.setConsole(console);
        when(console.getLine()).thenReturn("no").thenReturn("yes");

        contacts.buildContactsList();
        assertEquals(2, contacts.friends.size());

        verify(builder, times(2)).createPerson();
        verify(console, times(2)).getLine();
    }
}
