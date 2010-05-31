package net.azib.java.students.t092851.homework;

/**
 * DecathlonDataOutput
 *
 * @author Lauri
 */
public interface DecathlonDataOutput {

	/**
	 * @param data decathlon competition data to write into
	 * 			 implementation specific output
	 * @return true on success
	 */
	public boolean writeData(DecathlonData data);

}
