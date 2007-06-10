package net.azib.java.students.t030632.homework;



import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * OutFileWriterTest
 *
 * @author Toni
 */
public class OutFileWriterTest {
	private String givenResults;
	private String resultStrFromFile;
	private File testCSVFile; 
	@Before
	public void prepareData(){
		givenResults = "(1), Points: 4238, \"Siim Susi\" , 01.01.1976, Eesti, 12.61, 5.00, 9.22, 1.50, 59.39, 16.43, 21.60, 2.60, 35.81, 5:25.72. "+ "(2), Points: 3204, \"Beata Kana\", 01.03.1982, South Africa, 13.04, 4.53, 7.79, 1.55, 1:04.72, 18.74, 24.20, 2.40, 28.20, 6:50.76. ";
		String fs = File.separator;
		File testFile = new File(".."+fs+"java"+fs+"src"+fs+"net"+fs+"azib"+fs+"java"+fs+"students"+fs+"t030632"+fs+"homework"+fs+"test.csv");
		testCSVFile = new File(".."+fs+"java"+fs+"src"+fs+"net"+fs+"azib"+fs+"java"+fs+"students"+fs+"t030632"+fs+"homework"+fs+"testCSV.csv");
		FileOutputStream outStream;
		OutputStreamWriter outStreamWriter;
		BufferedWriter outBufWriter;
		
		try {
			outStream = new FileOutputStream(testFile);
			outStreamWriter = new OutputStreamWriter(outStream,"UTF8");
			outBufWriter = new BufferedWriter(outStreamWriter);
			
				outBufWriter.write("\"Siim Susi\" ,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72"+System.getProperty("line.separator"));
				outBufWriter.write("\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76"); 
			
			outBufWriter.close();
		}
		catch (IOException e) {
			System.err.println("Unable to write data to: "+ testFile.getAbsolutePath()+" file");
		}
		List <Competitor> list =  new FileProcessor(testFile).getCompetitors();
		testFile.delete();
		new OutFileWriter(testCSVFile,list);
		FileInputStream inStream;
		InputStreamReader inStreamReader;
		BufferedReader inBufReader;
		resultStrFromFile="";
		try {
			inStream = new FileInputStream(testCSVFile);
			inStreamReader = new InputStreamReader(inStream, "UTF8");
	        inBufReader = new BufferedReader(inStreamReader);
	        String competitorData;
	        
	        while((competitorData = inBufReader.readLine())!=null ){
	        	resultStrFromFile+=competitorData;
	        }
		}
		catch (FileNotFoundException e) {
			System.err.println(testCSVFile+ " File not Found!..");
		}
		catch (IOException e) {
			System.err.println("Error while reading file: "+testCSVFile);
		}
	
	}
	@Test
	public void testOutFileWriter() throws Exception {
		assertEquals(givenResults,resultStrFromFile);
	}
	@After
	public void deleteAuxilaryFiles(){
		testCSVFile.delete();
	}
	
	

}
