package net.azib.java.students.t020281.hometasks;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;


/**
 * FileCopierImplTest
 *
 * @author Trial
 */
public class FileCopierImplTest {
		
	@Test
	public void fileIsCopied () {
		FileOutputStream testFile = null;
	 	FileInputStream testFileCopy = null;
	 	FileCopierImpl fileCopy = null;
	 	String fileSrc = "./testfile.987";
	 	String fileDest = "./testfilecopy.987" ;
	    byte [] testBytes = new byte[] {1,2,3,4,5};
	 	byte [] testBytesCopied = new byte[5];
	 	
	try {	
		testFile = new FileOutputStream(fileSrc);
		testFile.write(testBytes);
		testFile.close();
		
		fileCopy = new FileCopierImpl();
		fileCopy.copy(new File(fileSrc), new File(fileDest));
		
		testFileCopy = new FileInputStream(fileDest);
		testFileCopy.read(testBytesCopied);
		testFileCopy.close();
		assertArrayEquals(testBytes,testBytesCopied);
	} 
	catch (IOException e) {}
	finally{
		if (testFile!= null) {
			try {
			testFile.close();
			}
			catch (IOException e) {}
		}
		if (testFileCopy!= null) {
			try {
			testFileCopy.close();
			}
			catch (IOException e) {}
		}
	}
	}
}
