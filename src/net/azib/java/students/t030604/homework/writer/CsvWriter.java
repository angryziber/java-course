package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.IDataWriter;
import net.azib.java.students.t030604.homework.domain.AthleteScore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * CSV file writer
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class CsvWriter extends AbstractWriter implements IDataWriter {
	
	private static final String FIELD_DELIMITER = ",";
	private static final String RECORD_DELIMITER = "\n";
	
	
	
	private FileWriter writer;

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#cleanup()
	 */
	public void cleanup() throws WriterException {
		try {
			if (writer != null) {
				writer.close();
			}
		} catch (IOException fatal) {
			throw new WriterException("cleanup failed", fatal);
		}

	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#output(java.util.List)
	 */
	public void output(List<AthleteScore> results)  throws WriterException {
		try {
			for (AthleteScore result : results) {
				writer.append(result.getRank()+"");
				if (result.getSharedRank() > 0) {
					writer.append("-" + result.getSharedRank());
				}
				writer.append(FIELD_DELIMITER)
						.append(result.getPoints()+"")
						.append(FIELD_DELIMITER)
						.append("\""+result.getName()+"\"")
						.append(FIELD_DELIMITER)
						.append(dateFormat.format(result.getBirthDate()))
						.append(FIELD_DELIMITER)
						.append(result.getCountry())
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getSprint100()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getLongJump()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getShotPut()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getHighJump()))
						.append(FIELD_DELIMITER)
						.append(timeFormat.format(result.getSprint400()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getHurdles110()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getDiscusThrow()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getPoleVault()))
						.append(FIELD_DELIMITER)
						.append(numberFormat.format(result.getJavelinThrow()))
						.append(FIELD_DELIMITER)
						.append(timeFormat.format(result.getRace1500()))
						.append(RECORD_DELIMITER);
			}
		} catch (IOException fatal) {
			throw new WriterException("output failed", fatal);
		}
	}	

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#setup()
	 */
	public void setup(String... args) throws WriterException {
		try {
			writer = new FileWriter(new File("output.csv"));
		} catch (IOException fatal) {
			throw new WriterException("unable to initialize output file", fatal);
		}
	}

}
