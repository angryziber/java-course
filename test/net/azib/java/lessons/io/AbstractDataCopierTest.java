package net.azib.java.lessons.io;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;


/**
 * Contract test for FileCopier implementations
 *
 * @author anton
 */
public abstract class AbstractDataCopierTest {
	protected DataCopier copier;

	public AbstractDataCopierTest(DataCopier copier) {
		this.copier = copier;
	}
	
	@Test
	public void copyWorks() throws Exception {
		byte[] data = System.getProperties().toString().getBytes();
		
		InputStream in = new ByteArrayInputStream(data);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		copier.copy(in, out);
		
		assertArrayEquals(data, out.toByteArray());
	}
}
