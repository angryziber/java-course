package net.azib.java.students.t020281.hometasks;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * BufferedCopyProgramTest
 *
 * @author Trial
 */
public final class BufferedCopyProgramTest {
	
	@Test
	public void fileIsCopied () {
		FileOutputStream testFile = null;
	 	FileInputStream testFileCopy = null;
	 	BufferedCopyProgram fileCopy = null;
	 	String fileSrc = "./testfile.987";
	 	String fileDest = "./testfilecopy.987" ;
	    byte [] testBytes = "copytest".getBytes();
	 	byte [] testBytesCopied = new byte[testBytes.length];

	 	
	try {	
		testFile = new FileOutputStream(fileSrc);
		testFile.write(testBytes);
		testFile.close();
		
		fileCopy = new BufferedCopyProgram();
		File src = new File(fileSrc);
		File dest = new File(fileDest);

		fileCopy.copy(src, dest);

		testFileCopy = new FileInputStream(fileDest);
		testFileCopy.read(testBytesCopied);
		testFileCopy.close();
		assertArrayEquals(testBytes,testBytesCopied);
		src.delete();
		dest.delete();
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
