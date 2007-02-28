package net.azib.java.students.t030655.Lab2ja4;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.easymock.EasyMock.*;
/**
 * MasterTest
 *
 * @author Triin
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t030655.Lab2ja4.Master#call(net.azib.java.students.t030655.Lab2ja4.IAnimal)}.
	 */
	@Test
	public void testCall() {
		IAnimal animal = createMock(IAnimal.class);
		expect(animal.getName()).andReturn("Animal");
		replay(animal);
		
		Master master = new Master();
		assertEquals("Hello, Animal", master.call(animal));
		verify(animal);
	}

}
