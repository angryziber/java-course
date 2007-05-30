package net.azib.java.students.t010687;

import java.io.File;
import org.junit.Test;


/**
 * FileListerTest
 *
 * @author t010687
 */
public class FileListerTest {
	@Test
	public void testListing() throws Exception {
		File file = new File(".");
		for (File f: file.listFiles()){
			if(f.isFile()){
				
			}
		}
	}

}
