package net.azib.java.students.t030632.homework;


import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.junit.Test;


/**
 * FileProcessorTest
 *
 * @author Toni
 */
public class FileProcessorTest {
	@Test
	public void testFileProcessor() throws Exception {
		String fs = File.separator;
		File testFile = new File(".."+fs+"java"+fs+"src"+fs+"net"+fs+"azib"+fs+"java"+fs+"students"+fs+"t030632"+fs+"homework"+fs+"test.csv");
		FileOutputStream outStream;
		OutputStreamWriter outStreamWriter;
		BufferedWriter outBufWriter;
		
		try {
			outStream = new FileOutputStream(testFile);
			outStreamWriter = new OutputStreamWriter(outStream,"UTF8");
			outBufWriter = new BufferedWriter(outStreamWriter);
			/*PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName),""));*/
			
				outBufWriter.write("\"Siim Susi\" ,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72"+System.getProperty("line.separator"));
				outBufWriter.write("\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76"); 
			
			outBufWriter.close();
		}
		catch (IOException e) {
			System.out.println("Unable to write data to: "+ testFile.getAbsolutePath()+" file");
		}
		List <Competitor> list =  new FileProcessor(testFile).getCompetitors();
		testFile.delete();
		assertEquals(2,list.size());
		
		
	}
}
