package net.azib.java.students.t104971.chars;

import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class PersonTest {
    @Test
    public void testToString() throws Exception {
        Person person = new Person();
        person.setName("Mati");
        person.setEmail("mati@hot.ee");
        person.setPhone("12345678");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1981, 0, 1);
        person.setBirthDay(calendar.getTime());
        assertEquals("Person {\n\t" +
                    "name='Mati'\n\t" +
                    "birth=01.01.1981\n\t" +
                    "email='mati@hot.ee'\n\t" +
                    "phone='12345678'\n" +
                    "}", person.toString());
    }
}
