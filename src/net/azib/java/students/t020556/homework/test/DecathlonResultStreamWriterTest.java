package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import net.azib.java.students.t020556.homework.DecathlonResultStreamWriter;
import net.azib.java.students.t020556.homework.IDecathlonResultReader;
import static org.easymock.EasyMock.*;

import org.junit.Test;

/**
 * DecathlonResultStreamWriterTest
 *
 * @author agu
 */
public class DecathlonResultStreamWriterTest {
	
	private DecathlonResultStreamWriter dsw = new DecathlonResultStreamWriter();

	/**
	 * Test method for {@link net.azib.java.students.t020556.homework.DecathlonResultStreamWriter#writeResults(net.azib.java.students.t020556.homework.IDecathlonResultReader)}.
	 */
	@Test
	public void testWriteResults() {
		IDecathlonResultReader r = createMock(IDecathlonResultReader.class);
		expect(r.readResults()).andReturn(null);
		replay(r);
		
		dsw.setStream(System.out);
		dsw.writeResults(r);
		
		verify(r);
	}

	/**
	 * Test method for {@link net.azib.java.students.t020556.homework.DecathlonResultStreamWriter#setFormat(boolean)}.
	 */
	@Test
	public void testSetFormat() {
		boolean CSV = false;
		dsw.setFormat(CSV);
		assertTrue(dsw.getFormat() == CSV);
		
	}

}
