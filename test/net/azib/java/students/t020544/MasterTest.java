package net.azib.java.students.t020544;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Test;

/**
 * MasterTest
 * 
 * @author Julija Kondratjeva
 */
public class MasterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t020544.Master#call(net.azib.java.students.t020544.IAnimal)}.
	 */
	@Test
	public void testCall() {
		IAnimal animal = createMock(IAnimal.class);// dog.getClass()
		expect(animal.getName()).andReturn("Animal");
		replay(animal);

		Master master = new Master();
		assertEquals("Hello, Animal", master.call(animal));
		verify(animal);// proverka vyzvali li animal.getName()
	}

}
