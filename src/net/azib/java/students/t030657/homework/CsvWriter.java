package net.azib.java.students.t030657.homework;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Karina
 * public class CsvWriter
 * In this class writing of the read data is committed
 * Used IO source - CSV
 *
 */
public class CsvWriter implements Writer {
	
	private static final String CSV_SEPARATOR = ",";
	private static final String lineSeparator = System.getProperty("line.separator");

	File file;
	OutputStreamWriter out;
	
	CsvWriter(File file) {
		this.file=file;
	}
	
	public void write(Results r) {
		try {
			if (out==null) {
				FileOutputStream fos = new FileOutputStream(file);
				out = new OutputStreamWriter(
					new BufferedOutputStream(fos), "UTF-8");
			}
			StringBuilder sb = new StringBuilder(132);
			sb
				.append(r.getPosition()).append(CSV_SEPARATOR)
				.append(r.getScore()).append(CSV_SEPARATOR)
				.append("\"").append(r.getAthlete().getName()).append("\""); 
			for (Event ev: Event.values()) {
				sb.append(CSV_SEPARATOR).append(r.getResult(ev));
			}
			sb.append(lineSeparator);
			out.write(sb.toString());
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public void close() {
		if (out!=null) {
			try { out.close(); }
			catch (IOException ignore) {}
		}
	}
}
