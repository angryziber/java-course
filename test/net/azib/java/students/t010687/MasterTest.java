package net.azib.java.students.t010687;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;


import org.junit.Test;

/**
 * MasterTest
 *
 * @author t010687
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t010687.Master#call(net.azib.java.students.t010687.IAnimal)}.
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
