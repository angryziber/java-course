package net.azib.java.students.t104971.chars;

import org.junit.Test;

import java.text.SimpleDateFormat;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static net.azib.java.students.t104971.chars.PersonBuilder.*;

/**
 * @author Jaroslav Judin
 */
public class PersonBuilderTest {

    @Test
    public void testValidateName() throws Exception {
        String name = "";
        assertNull(validateName(name));
        name = "Mart";
        assertNull(validateName(name));
        name = "Black Jack";
        assertEquals(name, validateName(name));
    }

    @Test
    public void testValidateEmail() throws Exception {
        String email = "john-312.e";
        assertNull(validateEmail(email));
        email = "@.ee";
        assertNull(validateEmail(email));
        email = "john@black.ee";
        assertEquals(email, validateEmail(email));
    }

    @Test
    public void testValidatePhone() throws Exception {
        String phone = "31ewqe";
        assertNull(validatePhone(phone));
        phone = "1420";
        assertNull(validatePhone(phone));
        phone = "+37254534534";
        assertEquals(phone, validatePhone(phone));
    }

    @Test
    public void testValidateDate() throws Exception {
        String date = "1.1.1988";
        assertNull(validateDate(date));
        date = "1985-01-01";
        assertNull(validateDate(date));
        date = "25.12.1986";
        assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse(date), validateDate(date));
    }
}
