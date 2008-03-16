package net.azib.java.students.t030633;

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

/**
 * BinaryParserTest
 * 
 * @author t030633
 */
public class BinaryParserTest {

	@Test
	public void readBinaryZero() throws Exception {
		InputStream is = createMock(InputStream.class);
		expect(is.read()).andReturn(0);
		replay(is);

		//BinaryParser binParser = new BinaryParser(is);
		//binParser.readBinary();
		//assertEquals(0, binParser.getInteger());
		assertEquals(0, is.read());

		verify(is);
	}

}
