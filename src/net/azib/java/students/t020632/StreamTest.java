package net.azib.java.students.t020632;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;

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
		InputStream is = new FileInputStream(filename);
		Reader reader = new InputStreamReader(is, "UTF-8");
		while(reader.ready()){
			System.out.print((char)reader.read());
		}
		reader.close();
		

	}

}
