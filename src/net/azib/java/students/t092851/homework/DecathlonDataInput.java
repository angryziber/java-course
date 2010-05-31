package net.azib.java.students.t092851.homework;

/**
 * DecathlonDataInput
 *
 * @author Lauri
 */
public interface DecathlonDataInput {

	/**
	 * Reads decathlon competition data from implementation specific input 
	 * @return decathlon competition data; in case of failure returns 'null'
	 */	
	public DecathlonData readData();

}
