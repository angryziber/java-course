package net.azib.java.students.t073857.hw5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * NameTest
 *
 * @author JoonasVali
 */
public class NameTest {
	String n = "Carl Robert Jakobson";
	Name name = new Name(n);
	@Test
	public void initialization(){
		assertEquals(n, name.toString());
	}
	
	@Test
	public void checkTrim(){
		name = new Name(" Carl    Robert Jakobson            ");
		assertEquals("Carl Robert Jakobson", name.toString());
	}
	
	@Test
	public void throwErrorOnNull(){
		try{
			name = new Name(null);
			throw new AssertionError("Name should not be initialized with null");
		} catch(IllegalArgumentException e){}		
	}
	
	@Test
	public void allowShortNames(){
		name = new Name("Mr.Bush");
		assertEquals("Mr.Bush", name.toString());
	}
	
	@Test
	public void firstNames(){
		assertEquals("Carl", name.getFirstName());
		name = new Name("Carl");
		assertEquals("Carl", name.getFirstName());		
		name = new Name("     Carl  Robert Jakobson      ");
		assertEquals("Carl", name.getFirstName());
	}
	
	@Test
	public void lastNames(){
		assertEquals("Jakobson", name.getLastName());
		name = new Name("Carl");
		assertEquals("", name.getLastName());		
		name = new Name("     Carl  Robert Jakobson      ");
		assertEquals("Jakobson", name.getLastName());
	}	
}
