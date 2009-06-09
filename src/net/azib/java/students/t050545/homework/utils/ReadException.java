package net.azib.java.students.t050545.homework.utils;

/**
 * ReadException, AthleteLoaders exception
 * when loader can't open source or can't read data
 * @author libricon
 */
public class ReadException extends Exception {
	/** @param message problem description */
	public ReadException(String message) {
		super(message);
	}

}
