package net.azib.java.students.t050209;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*; /* imporditakse klassi static muutujad*/

import org.junit.Test;

/**
 * MasterTest
 *
 * @author t050209
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t050209.Master#call(net.azib.java.students.t050209.Ianimal)}.
	 */
	@Test
	public void testCall() {
		Ianimal animal = createMock(Ianimal.class); /* getClass*/
		expect(animal.getName()).andReturn("Animal");
		replay(animal);
		
		Master master = new Master();
		assertEquals("Hello, Animal", master.call(animal));
		verify(animal); /*pole hädavajalik, kuid vajalik kontrollimaks kas getName kasutati*/
	}

}
