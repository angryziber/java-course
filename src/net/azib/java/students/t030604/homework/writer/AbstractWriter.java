package net.azib.java.students.t030604.homework.writer;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * base class to hold some common formatters
 * and utility methods for IDataWriter implementations
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public abstract class AbstractWriter {
	
	protected static final DateFormat dateFormat;
	protected static final NumberFormat numberFormat; 
	
	static {
		dateFormat = new SimpleDateFormat("dd.mm.yyyy");
		numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMinimumFractionDigits(2);
		numberFormat.setMaximumFractionDigits(2);
	}

}
