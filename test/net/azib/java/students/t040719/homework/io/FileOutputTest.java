package net.azib.java.students.t040719.homework.io;


import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.Decathlon;

import static junit.framework.Assert.assertEquals;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLValid;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.custommonkey.xmlunit.Validator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.hibernate.cfg.Environment;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * FileOutputTest
 *
 * @author romi
 */
public class FileOutputTest {

	private int errorCode;
	
	private Document parse(URL url) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
	
	private String xmlToString(Document doc) throws IOException{
		OutputFormat format = OutputFormat.createCompactFormat();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLWriter writer = new XMLWriter( out, format );
        writer.write(doc);
        return out.toString();
	}
	
	private List<Athlete> getAthleteList() throws ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1999");
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		Athlete ath = new Athlete("Siim Susi", d, "EE", realResults);
		List<Athlete> al = new ArrayList<Athlete>();
		al.add(ath);
		return al;
	}
	
	@Test
	public void testOutputResultsForEmptyArguments(){
		FileOutput xmlo = new FileOutput() {
			@Override
	         public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		};
		xmlo.outputResults(null, "asd");
		assertEquals(11,errorCode);
		xmlo.outputResults(new ArrayList<Athlete>(), (String[])null);
		assertEquals(12, errorCode);
		xmlo.outputResults(new ArrayList<Athlete>(), "");
		assertEquals(12, errorCode);
		xmlo.outputResults(new ArrayList<Athlete>());
		assertEquals(12, errorCode);
		xmlo.outputResults(new ArrayList<Athlete>(),"nothing","-db");
		assertEquals(12, errorCode);
	}
	
	@Test
	public void testMakeXMLDocumentWithNoAthletes() throws IOException{
		Document doc1 = FileOutput.makeXMLDocument(new ArrayList<Athlete>());
		Document doc2 = DocumentHelper.createDocument();
        doc2.addElement("decathlon")
        	.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
        	.addAttribute(new QName("xsi:noNamespaceSchemaLocation",Namespace.NO_NAMESPACE), "http://rmg.planet.ee/DecathlonResults.xsd");

        assertEquals(xmlToString(doc1), xmlToString(doc2));	
	}

	@Test
	public void testMakeXMLDocument() throws ParseException, DocumentException, URISyntaxException, IOException{
		List<Athlete> al = getAthleteList();
		Document doc1 = FileOutput.makeXMLDocument(al);
		Document doc2 = parse(FileOutputTest.class.getResource(("test.xml")).toURI().toURL());
        assertEquals(xmlToString(doc1), xmlToString(doc2));	
	}
	
	@Test
	public void testOutputResults() throws ParseException, DocumentException, URISyntaxException, IOException{
		List<Athlete> al = getAthleteList();
		File tmpFile = File.createTempFile("test", ".tmp");
		new FileOutput(tmpFile).outputResults(al, "nothing", "-xml");
		File tmpFile2 = new File(FileOutputTest.class.getResource(("test.xml")).toURI().getPath());
        assertEquals(tmpFile.length(), tmpFile2.length());	
	}
	
	@Test
	public void testIfXMLIsValid() throws Exception {
		Document doc = FileOutput.makeXMLDocument(getAthleteList());
		//InputStreamReader xmlReader = new InputStreamReader(getClass().getResourceAsStream("test.xml"));
		String xsdPath = Decathlon.class.getResource("xml/DecathlonResults.xsd").getPath();
		
		Validator validator = new Validator(doc.asXML(), xsdPath);
		validator.useXMLSchema(true);

		assertXMLValid(validator);
	}
	
	@Test
	public void testValidatorWIthEmptyParameters() {
		assertEquals(false, FileOutput.isValidXML("", ""));
	}
	
	@Test
	public void testFindPlaceSharers(){
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		List<Athlete> al = new ArrayList<Athlete>();
		al.add(new Athlete("Siim Susi",new Date(), "EE", realResults));
		al.add(new Athlete("Margus Murakas",new Date(), "EE", new float[10]));
		al.add(new Athlete("John Doe",new Date(), "UK", new float[10]));
		assertEquals("2-3", FileOutput.findPlaceSharers(al, 1));
	}
	
	@Test
	public void testXMLToFile() throws ParseException, DocumentException, URISyntaxException, IOException{
		List<Athlete> al = getAthleteList();
		File tmpFile = File.createTempFile("test1", ".tmp");
		Document doc = FileOutput.makeXMLDocument(al);
		new FileOutput(tmpFile).writeXMLToFile(doc);
		File tmpFile2 = new File(FileOutputTest.class.getResource(("test.xml")).toURI().getPath());
        assertEquals(tmpFile.length(), tmpFile2.length());	
	}
	
	@Test
	public void testXMLToCSV() throws ParseException, DocumentException, URISyntaxException, IOException{
		List<Athlete> al = getAthleteList();
		File tmpFile = File.createTempFile("test2", ".tmp");
		Document doc = FileOutput.makeXMLDocument(al);
		new FileOutput(tmpFile).toCSVFile(doc);
		File tmpFile2 = new File(FileOutputTest.class.getResource(("test.csv")).toURI().getPath());
		String line1,line2;
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(tmpFile),"UTF-8"));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(tmpFile2),"UTF-8"));
		while((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null)
			assertEquals(line1, line2);	
	}

	@Test
	public void testXMLToHTML() throws ParseException, DocumentException, URISyntaxException, IOException{
		List<Athlete> al = getAthleteList();
		File tmpFile = File.createTempFile("test3", ".tmp");
		Document doc = FileOutput.makeXMLDocument(al);
		new FileOutput(tmpFile).toHTMLFile(doc);
		File tmpFile2 = new File(FileOutputTest.class.getResource(("test.html")).toURI().getPath());
        assertEquals(tmpFile.length(), tmpFile2.length());	
	}
	
	@Test
	public void testXMLToHTMLWithNullParameter() throws ParseException, DocumentException, URISyntaxException, IOException{
		new FileOutput(File.createTempFile("test4", ".tmp")){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.toHTMLFile(null);
		assertEquals(15, errorCode);
	}
	
	@Test
	public void testXMLToCSVWithNullParameter() throws ParseException, DocumentException, URISyntaxException, IOException{
		new FileOutput(File.createTempFile("test4", ".tmp")){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.toCSVFile(null);
		assertEquals(17, errorCode);
	}
	
	@Test
	public void testTransformDocumentWithNullParameters(){
		new FileOutput(){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.transformDocument(null, null);
		assertEquals(17, errorCode);		
	}
	
	@Test
	public void testTransformDocumentWithNonExistingStylesheet() throws URISyntaxException, ParseException{
		Document doc = FileOutput.makeXMLDocument(getAthleteList());
		new FileOutput(){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.transformDocument(doc, new URI("/nofile.no"));
		assertEquals(16, errorCode);		
	}

	@Test
	public void testStyleDocumentWithNonExistingStylesheet() throws URISyntaxException, ParseException{
		Document doc = FileOutput.makeXMLDocument(getAthleteList());
		new FileOutput(){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.styleDocument(doc, new URI("/nofile.no"));
		assertEquals(16, errorCode);		
	}
	
	@Test
	public void testTransformDocument() throws URISyntaxException, ParseException, IOException{
		Document doc = FileOutput.makeXMLDocument(getAthleteList());
		URI stylesheetPath = Decathlon.class.getResource("xml/csv.xsl").toURI();
		
		byte[] transDoc = new FileOutput(){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.transformDocument(doc, stylesheetPath);
		File tmpFile = new File(FileOutputTest.class.getResource(("test.csv")).toURI().getPath());
		int len = (int)(tmpFile.length());
        FileInputStream fis = new FileInputStream(tmpFile);
        byte buf[] = new byte[len];
        fis.read(buf);
        fis.close();
        String[] str1 = new String(transDoc,"UTF8").split(System.getProperty("line.separator"));
        String[] str2 = new String(buf,"UTF8").split("\r\n");
        assertEquals(str1.length, str2.length);
        for (int i=0; i<str1.length; i++)
        	assertEquals(str1[i], str2[i]);
        //assertEquals(new String(transDoc,"UTF8"), new String(buf,"UTF8"));
//        assertEquals(len, transDoc.length);
//        for (int i=0; i<len; i++){
//        	assertEquals(buf[i], transDoc[i]);
//        }				
	}
	
//	private Document getXMLDocument(String xml) throws DocumentException, SAXException {
//        SAXReader reader = new SAXReader();
//        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",false);
//        StringReader in = new StringReader(xml);
//        Document domdoc = reader.read(in);
//        return domdoc;
//    }
	
	private Document getDocument( final String xmlFileName ) throws SAXException, DocumentException
	{
		Document document = null;
		SAXReader reader = new SAXReader();
        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",false);
        document = reader.read( xmlFileName );
        return document;
	}
	
	@Test
	public void testStyleDocument() throws URISyntaxException, ParseException, IOException, DocumentException, SAXException{
		Document doc = FileOutput.makeXMLDocument(getAthleteList());
		URI stylesheetPath = Decathlon.class.getResource("xml/html.xsl").toURI();
		
		Document styleDoc = new FileOutput(){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.styleDocument(doc, stylesheetPath);		
		assertEquals(getDocument(FileOutputTest.class.getResource(("test.html")).toURI().getPath()).asXML().replaceAll("\\s", ""), styleDoc.asXML().replaceAll("\\s", ""));		
	}
	
	@Test
	public void testStyleDocumentWithNullParameters(){
		new FileOutput(){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.styleDocument(null, null);
		assertEquals(15, errorCode);		
	}
	
	@Test
	public void testXMLToFileWithNonWritableFile() throws ParseException{
		List<Athlete> al = getAthleteList();
		File noFile = new File("X1H4R/ aldljaf.tmp");
		Document doc = FileOutput.makeXMLDocument(al);
		new FileOutput(noFile){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.writeXMLToFile(doc);
        assertEquals(14, errorCode);	

	}
	
	@Test
	public void testXMLToCSVWithNonWritableFile() throws ParseException{
		List<Athlete> al = getAthleteList();
		File noFile = new File("X1H4R/ aldljaf.tmp");
		Document doc = FileOutput.makeXMLDocument(al);
		new FileOutput(noFile){
			@Override
			public void exit(int errorCode) {
	        	 FileOutputTest.this.errorCode = errorCode;
	         }
		}.toCSVFile(doc);
        assertEquals(13, errorCode);	
	}
	
	@Test
	public void testFindPlaceSharersWithIncorrectArguments(){	
        assertEquals("-", FileOutput.findPlaceSharers(new ArrayList<Athlete>(),2));	
	}

}
