package net.azib.java.students.t090437.homework;

import javax.xml.transform.stream.StreamSource;

/**
 * CompetitionToHTML
 * 
 * Class for creating HTML document from the competition data. Uses CompetitionToXML class 
 * to create an XML document object from the data results.xsl XSLT transform stylesheet 
 * file for transforming the XML object to HTML file.
 *
 * @author Ronald
 */
public class CompetitionToHTML extends CompetitionToXML {
	/**
	 * @param outputFileName
	 */
	public CompetitionToHTML(String outputFileName) {
		super(outputFileName);
	}
	
	@Override
	public void produceResults() throws MyException{
		setTransformerStylesheet(new StreamSource(getClass().getResource("results.xsl").toString()));
		try {
			super.produceResults();
		}
		catch (MyException e) {
			throw new MyException("Unable to produce HTML output.\r\n" + e);
		}
	}

}
