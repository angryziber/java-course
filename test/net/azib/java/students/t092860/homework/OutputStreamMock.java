package net.azib.java.students.t092860.homework;

import java.io.IOException;
import java.io.OutputStream;

/**
 * FileOutputStreamMock
 *
 * @author armin
 */
public class OutputStreamMock extends OutputStream{

	@Override
	public void write(int b) throws IOException {
		data += (char)b;
	}
	
	public String read() {
		return String.valueOf(data);		
	}
	
	private String data = "";
}
