package net.azib.java.students.t020556;

import junit.framework.Assert;
import static org.easymock.EasyMock.*;

import org.easymock.EasyMock;
import org.junit.Test;

/**
 * MasterTest
 *
 * @author t020556
 */
public class MasterTest {

	/**
	 * Test method for {@link net.azib.java.students.t020556.Master#callDog(net.azib.java.students.t020556.IAnimal)}.
	 */
	@Test
	public void testCallDog() {
		//init instances
		Master master = new Master();
		IAnimal dog = EasyMock.createMock(IAnimal.class);
		
		//override the methods to return specific values needed for testing: "record"
		expect(dog.getName()).andReturn("Animal").atLeastOnce();
		replay(dog); //and finish overriding: "stop recording"
		
		//run test
		Assert.assertEquals(master.callDog(dog), "Hello, Animal");
		
		//verify that the method dog.getName() method has been called
		verify();
	}

}
