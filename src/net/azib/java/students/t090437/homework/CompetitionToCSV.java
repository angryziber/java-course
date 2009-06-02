package net.azib.java.students.t090437.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.SortedSet;

/**
 * CompetitionToCSV
 *
 * @author Ronald
 */
public class CompetitionToCSV implements CompetitionResultsProducer {
	private String outputFileName;
	private SortedSet<Competitor> competitors;
	
	public CompetitionToCSV(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
	@Override
	public void produceResults() throws MyException {
		OutputStreamWriter writer = null;;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8");
			
			for(Competitor competitor : competitors) {
				writer.write(competitor.getPosition() + "," + Integer.toString(competitor.getScore()) + 
						",\"" + competitor.getName() + "\"," + competitor.getBirthdayStr() + "," + competitor.getCountry() +
						"," + competitor.getSprint_100m_s() + "," + competitor.getLong_jump_m() +
						"," + competitor.getShot_put_m() + "," + competitor.getHigh_jump_m() +
						"," + competitor.getSprint_400m_m_s() + "," + competitor.getHurdles_s() +
						"," + competitor.getDiscus() + "," + competitor.getPole_vault() +
						"," + competitor.getJavelin_throw() + "," + competitor.getRace_1500m_m_s() +
						"\r\n");
			}
		}
		catch (UnsupportedEncodingException e) {
			throw new MyException("Encoding UTF-8 is not supported.");
		}
		catch (FileNotFoundException e) {
			throw new MyException("Unable to write to open file " + outputFileName + " for writing.");
		}
		catch (IOException e) {
			throw new MyException("Unable to write to file " + outputFileName);
		} finally {
			try {
				writer.close();
			}
			catch (IOException e) {
			}
		}	
	}

	@Override
	public void setCompetitionResults(SortedSet<Competitor> competitors) {
		this.competitors = competitors;		
	}

}
