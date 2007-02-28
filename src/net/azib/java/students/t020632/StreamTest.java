package net.azib.java.students.t020632;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

/**
 * StreamTest
 *
 * @author t020632
 */
public class StreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		
		String filename = ".classpath";
		Reader reader = new FileReader(filename);
		System.out.println(reader.read());
		reader.close();
		

	}

}
