package net.azib.java.students.t020632;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import net.azib.java.lessons.misc.IAnimal;

import org.junit.Test;

/**
 * MasterTest
 *
 * @author t020632
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t020632.Master#call(net.azib.java.students.t020632.IAnimal)}.
	 */
	@Test
	public void testCall() {
		IAnimal animal = createMock(IAnimal.class);
		expect(animal.getName()).andReturn(" animal");
		replay(animal);
		
		Master master = new Master();
		assertEquals("hello animal", master.call(animal));
		verify(animal);
	}

}
