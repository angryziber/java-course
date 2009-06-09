package net.azib.java.students.t050545.homework.utils;

/**
 * WriteException, AthleteWriters call 
 * when can't write data to destination
 * @author libricon
 */
public class WriteException extends Exception{
	/** @param message problem description*/
	public WriteException(String message) {
        super(message);
     }
}
