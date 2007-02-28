package net.azib.java.lessons.misc;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Test;

/**
 * MasterTest
 *
 * @author anton
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.lessons.misc.Master#call(net.azib.java.lessons.misc.IAnimal)}.
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
