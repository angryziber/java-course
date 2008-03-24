package net.azib.java.lessons.io;

import org.junit.Test;

/**
 * AbstractFileCopierTest
 *
 * @author anton
 */
public abstract class AbstractFileCopierTest {
	private FileCopier copier;

	public AbstractFileCopierTest(FileCopier copier) {
		this.copier = copier;
	}
	
	@Test
	public void copyWorks() throws Exception {
		
	}
	
	
}
