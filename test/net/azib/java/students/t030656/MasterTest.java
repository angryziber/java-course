package net.azib.java.students.t030656;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.junit.*;
/**
 * MasterTest
 *
 * @author t030656
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t030656.Master#call(IAnimal)}.
	 */
	@Test
	public void testCall() {
		IAnimal animal = createMock(IAnimal.class);
		expect(animal.getName()).andReturn("Loom");
		replay(animal);
		
		Master master = new Master();
		assertEquals("Hei, Loom", master.call(animal));
		verify(animal);
	}

}
