package net.azib.java.lessons.basic;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;


/**
 * AnimalKeeperTest
 *
 * @author anton
 */
public class AnimalKeeperTest {
	

	@Test
	public void toStringCallsAnimalToString() throws Exception {
		Animal mockAnimal = createMock(Animal.class);
		expect(mockAnimal.getName()).andReturn("ABC").times(2);
		
		replay(mockAnimal);
		
		AnimalKeeper ak = new AnimalKeeper();
		ak.obtainAnimal(mockAnimal);
		// TODO: support singulars
		assertEquals("I have 1 animals:\nABC", ak.toString());
		
		verify(mockAnimal);
	}
}
