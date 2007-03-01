package net.azib.java.students.t030636.first;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.easymock.EasyMock.*;

/**
 * MasterTest
 *
 * @author Martin
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t030636.first.Master#call(net.azib.java.students.t030636.first.IAnimal)}.
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
