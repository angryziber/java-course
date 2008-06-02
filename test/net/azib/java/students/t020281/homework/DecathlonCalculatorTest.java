package net.azib.java.students.t020281.homework;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.junit.Test;

/**
 * DecathlonCalculatorTest
 *
 * @author Trial
 */
public class DecathlonCalculatorTest {
	
	public void processInput(DecathlonCalculator dc, String s, OutputStream out) throws Exception{
		
			Scanner in = new Scanner(s);
			String[] res = dc.readFromStream(in, new PrintStream(out));
			for (int j = 0; j < res.length; j++) {
				Sportsman person = new Sportsman(res[j]);
				dc.sportsmenList.add(person);
			}

	}
	
	@Test
	public void readFromConsoleTest() throws Exception {
		String LN = System.getProperty("line.separator");
		String input ="Szőrös Szűk"+LN+"3.04.1972"+LN+"HU"+LN+"13.75"+LN+"1:08.44"+LN+"19.18";
		input +=LN+"6:22.7"+LN+"54.84"+LN+"10.12"+LN+"1.50"+LN+"30.85"+LN+"2.80"+LN+"33.88"+LN+"no"+LN+"n"+LN;
		
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    DecathlonCalculator dc = new DecathlonCalculator();
	    
		processInput(dc, input, out);
		String expected="Welcome to Decathlon points calculator! Please insert sportsmen achievements:"+LN;
		expected+="Sportsman 1 data is: "+LN;
		expected+="Name: Date of birth: Country Code: 100 m sprint (sec):400 m sprint (min:sec):110 m hurdles (sec):1500 m race (min:sec):Long jump (m):Shot put (m):High jump (m):Discus throw (m):Pole vault (m):Javelin throw (m):Do you want to add another sportsman?(y/n): Please enter y or n: ";
		String actual=out.toString();
		assertEquals(expected,actual);
		double actualDouble = dc.sportsmenList.getFirst().getRace1500mEvent();
		double expectedDouble = 382.7;
		assertEquals(expectedDouble,actualDouble);
		
	}
	
	@Test
	public void readFromCSVTest(){
		DecathlonCalculator dc = new DecathlonCalculator();
		String results ="\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75";
		File tmp = null;
		try {
			tmp = File.createTempFile("test", "tmp");
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp),"UTF8"));
			writer.write(results);
			writer.close();
			InputStream input = new FileInputStream(tmp);
			String[] res = dc.readFromCSV(input);
			String actual = res[0];
			String expected = "\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75";
			assertEquals(expected, actual);
			input.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	@Test
	public void calculatePlacesAndProcessInputTest(){
		DecathlonCalculator dc = new DecathlonCalculator();
		String results1 = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,64.72,18.74,24.20,2.40,28.20,410.76";
		String results ="\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75";
		StringBuilder builder = new StringBuilder();
		File tmp = null;
		try {
			tmp = File.createTempFile("test", "tmp");
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmp),"UTF8"));
			builder.append(results).append("\n").append(results).append("\n").append(results1);
			writer.write(builder.toString());
			writer.close();
			InputStream input = new FileInputStream(tmp);
			String[] res = dc.readFromCSV(input);
			input.close();
			dc.processInput(res);
			String actual = dc.places[0];
			String expected = "1-2";
			assertEquals(expected, actual);
			actual = dc.places[2];
			expected = "3";
			assertEquals(expected, actual);
			Double actualDouble = dc.sportsmenList.get(1).getSprint100mEvent();
			Double expectedDouble = 13.04;
			assertEquals(expectedDouble, actualDouble);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void writeToConsoleTest() throws UnsupportedEncodingException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonCalculator dc = new DecathlonCalculator();
		String results ="\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,382.75";
		String[] res = new String[]{results};
		dc.processInput(res);
		dc.writeToConsole(out);
		StringBuilder expected = new StringBuilder();
		expected.append("Szőrös Szűk (03.04.1972) HU results:\n");
		expected.append("100 m sprint (sec): 13.75\n");
		expected.append("Long jump (m): 4.84\n");
		expected.append("Shot put (m): 10.12\n");
		expected.append("High jump (m): 1.50\n");
		expected.append("400 m sprint (sec): 68.44\n");
		expected.append("110 m hurdles (sec): 19.18\n");
		expected.append("Discus throw (m) : 30.85\n");
		expected.append("Pole vault (m): 2.80\n");
		expected.append("Javelin throw (m): 33.88\n");
		expected.append("1500 m race (sec): 382.75\n");
		expected.append("Decathlon Points: 3339\n");
		expected.append("Place: 1\n\n");
		String actual = out.toString("UTF8");
		assertEquals(expected.toString(), actual);
	}
	
	@Test
	public void writeToCSVTest() throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonCalculator dc = new DecathlonCalculator();
		String results ="\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.50,68.44,19.18,30.85,2.80,33.88,382.75";
		String[] res = new String[]{results};
		dc.processInput(res);
		dc.writeToCSV(out);
		String expected = results+",3339,1\n";
		String actual = out.toString("UTF8");
		assertEquals(expected, actual);
		out.close();
	}
	
	@Test
	public void writeToXMLTest() throws UnsupportedEncodingException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonCalculator dc = new DecathlonCalculator();
		String results ="\"Szőrös Szűk\",03.04.1972,HU,13.75,4.84,10.12,1.50,68.44,19.18,30.85,2.80,33.88,382.75";
		String[] res = new String[]{results};
		dc.processInput(res);
		dc.writeToXML(out);
		StringBuilder expected = new StringBuilder();
		expected.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		expected.append("<results xsi:noNamespaceSchemaLocation=\"");
		expected.append(DecathlonCalculator.class.getResource("decathlon.xsd")); 
		expected.append("\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n");
		expected.append("<sportsman>\n");
		expected.append("<name>Szőrös Szűk</name>\n");
		expected.append("<birthDate>03.04.1972</birthDate>\n");
		expected.append("<country>HU</country>\n");
		expected.append("<sprint100mEvent>13.75</sprint100mEvent>\n");
		expected.append("<longJumpEvent>4.84</longJumpEvent>\n");
		expected.append("<shotPutEvent>10.12</shotPutEvent>\n");
		expected.append("<highJumpEvent>1.50</highJumpEvent>\n");
		expected.append("<sprint400mEvent>68.44</sprint400mEvent>\n");
		expected.append("<hurdles110mEvent>19.18</hurdles110mEvent>\n");
		expected.append("<discusThrowEvent>30.85</discusThrowEvent>\n");
		expected.append("<poleVaultEvent>2.80</poleVaultEvent>\n");
		expected.append("<javelinThrowEvent>33.88</javelinThrowEvent>\n");
		expected.append("<race1500mEvent>382.75</race1500mEvent>\n");
		expected.append("<points>3339</points>\n");
		expected.append("<place>1</place>\n");
		expected.append("</sportsman>\n");
		expected.append("</results>");
		String actual = out.toString("UTF8");
		assertEquals(expected.toString(), actual);
	}
	
	@Test
	public void writeToHtmlTest() throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonCalculator dc = new DecathlonCalculator();
		String results ="\"Janis Litoměřice\",06.06.1985,LV,11.52,7.87,12.40,2.05,50.05,15.60,39.00,5.45,55.95,274.42";
		String[] res = new String[]{results};
		dc.processInput(res);
		dc.writeToHtml(out);
		String LN = System.getProperty("line.separator");
		StringBuilder expected = new StringBuilder();
		expected.append("<html>").append(LN);
		expected.append("<head>").append(LN);
		expected.append("<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">").append(LN);
		expected.append("</head>").append(LN);
		expected.append("<body>").append(LN);
		expected.append("<h1>Decathlon Points Caltulation results:</h1>").append(LN);
		expected.append("<p>").append(LN);
		expected.append("<h3>Sportsman:").append(LN);
		expected.append("  Janis Litoměřice ").append(LN);
		expected.append("   (").append(LN);
		expected.append("   06.06.1985").append(LN);
		expected.append("   ) ").append(LN);
		expected.append("   LV</h3>").append(LN);
		expected.append("</p>").append(LN);
		expected.append("<p>").append(LN);
		expected.append("<h4>Place:").append(LN);
		expected.append("     1</h4>").append(LN);
		expected.append("</p>").append(LN);
		expected.append("<p>").append(LN);
		expected.append("<b>100 m sprint (sec):</b>11.52<br>").append(LN);
		expected.append("<b>Long jump (m):</b>7.87<br>").append(LN);
		expected.append("<b>Shot put (m):</b>12.40<br>").append(LN);
		expected.append("<b>High jump (m):</b>2.05<br>").append(LN);
		expected.append("<b>400 m sprint (sec):</b>50.05<br>").append(LN);
		expected.append("<b>110 m hurdles (sec):</b>15.60<br>").append(LN);
		expected.append("<b>Discus throw (m):</b>39.00<br>").append(LN);
		expected.append("<b>Pole vault (m):</b>5.45<br>").append(LN);
		expected.append("<b>Javelin throw (m):</b>55.95<br>").append(LN);
		expected.append("<b>1500 m race (sec):</b>274.42<br>").append(LN);
		expected.append("<b>Decathlon points:</b>7209</p>").append(LN);
		expected.append("<hr>").append(LN);
		expected.append("</body>").append(LN);
		expected.append("</html>").append(LN);
		
		String actual = out.toString("UTF8");
		assertEquals(expected.toString(), actual);
	}
	
}
