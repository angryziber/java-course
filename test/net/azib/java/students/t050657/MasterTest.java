package net.azib.java.students.t050657;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import net.azib.java.students.t050657.Class.IAnimal;
import net.azib.java.students.t050657.Class.Master;

import org.junit.Test;

/**
 * MasterTest
 *
 * @author t050657
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t050657.Master#call
	 * 						 (net.azib.java.students.t050657.IAnimal)}.
	 */
	@Test
	public void testCall() {
		IAnimal animal = createMock(IAnimal.class);
		expect(animal.getName()).andReturn("Animal");
		replay(animal);
		
		Master m = new Master();
		assertEquals("Master.call(animal) failed!", "Hello Animal", m.call(animal));
		verify(animal);
		
	}

}
