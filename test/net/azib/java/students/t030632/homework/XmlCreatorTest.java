package net.azib.java.students.t030632.homework;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

//import javax.xml.validation.Validator;
import org.custommonkey.xmlunit.Validator;
//import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;


/**
 * XmlCreatorTest
 *
 * @author Toni
 */
public class XmlCreatorTest {
	
	@Test
	public void testXmlCreator() throws Exception {
		List <Competitor> champsLIst = new LinkedList<Competitor> ();
		champsLIst.add(new Competitor("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 "));// points 4238
		champsLIst.add(new Competitor("\"Siim Silm\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 "));// points 4238
		champsLIst.add(new Competitor("\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 "));// points 3204
		String fs = File.separator;
		File xmlFile = new File(".."+fs+"java"+fs+"src"+fs+"net"+fs+"azib"+fs+"java"+fs+"students"+fs+"t030632"+fs+"homework"+fs+"test.xml");
		new XmlCreator(xmlFile,champsLIst);
		InputStreamReader xmlReader = new InputStreamReader(new FileInputStream(xmlFile),"UTF8");//utf-8 seems needless
		String xsdPath = ".."+fs+"java"+fs+"src"+fs+"net"+fs+"azib"+fs+"java"+fs+"students"+fs+"t030632"+fs+"homework"+fs+"Competitor.xsd";
		Validator v = new Validator(xmlReader, xsdPath);
		v.useXMLSchema(true);
		v.assertIsValid();
	}
}
