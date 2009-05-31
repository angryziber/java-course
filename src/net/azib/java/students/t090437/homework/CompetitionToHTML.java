package net.azib.java.students.t090437.homework;

import javax.xml.transform.stream.StreamSource;

/**
 * CompetitionToHTML
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
	public void produceResults() {
		setTransformerStylesheet(new StreamSource(getClass().getResource("results.xsl").toString()));
		super.produceResults();
	}

}
