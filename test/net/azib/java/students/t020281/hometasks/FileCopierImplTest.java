package net.azib.java.students.t020281.hometasks;

<<<<<<< .mine
import java.io.FileOutputStream;
import java.io.IOException;

=======
import org.junit.Test;

>>>>>>> .r1218
/**
 * FileCopierImplTest
 *
 * @author Trial
 */
public class FileCopierImplTest {
	@Test
	public void todo() throws Exception {
	}
	//@Test
	public void fileIsCopied () {
		FileOutputStream testFile = null;
	//	FileInputStream testFile1 = null;
	try {
		int b = 12345;
		testFile = new FileOutputStream("./testfile.987");
		testFile.write(b);
		testFile.close();
		

	//	assertEquals()
	} 
	catch (IOException e) {}
	finally{
		if (testFile!= null) {
			try {
			testFile.close();
			}
			catch (IOException e) {}
		}
	}
	}
}
