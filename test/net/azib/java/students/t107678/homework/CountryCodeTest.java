package net.azib.java.students.t107678.homework;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class CountryCodeTest {

    CountryCode countryCode = new CountryCode("me");


    @Test
    public void testGetValue() throws Exception {

        assertEquals("ME",countryCode.getValue());

    }

    @Test
    public void testIncorrectCountryCode() throws Exception{

        CountryCode countryCode1 = new CountryCode("ee");
        assertNotSame(countryCode1, countryCode);
    }

}
