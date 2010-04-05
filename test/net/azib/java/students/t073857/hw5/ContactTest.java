package net.azib.java.students.t073857.hw5;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * ContactTest
 *
 * @author Joonas Vali
 */
public class ContactTest {
	Contact contact = new Contact(new Name("Carl Robert Jacobson"), new Date(), new Email("Carl.Robert.Jacobson@hotmail.com"), 73189738);
	
	@Test
	public void initialization(){
		/*String ans = "Carl Robert Jacobson |  | Carl.Robert.Jacobson@hotmail.com | 73189738"
		assert
		System.out.println(contact);*/
	}
}
