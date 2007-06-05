package net.azib.java.students.t020543.homework;

import java.util.Set;

/**
* An output interface
* @author t020543
*/
public interface IOutput {
	
	/**
	 * Creates a file, which contains sorted set of athletes with calculated score and given place. 
	 * @param set of competitors, needed to be written
	 * @param destination - file name or path
	 */
	public abstract void saveFile(Set<Competitor> set, String destination); 
}
