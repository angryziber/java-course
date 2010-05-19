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
		//System.out.print((char)b);
		data.append((char)b);
	}
	
	public String read() {
		return data.toString();		
	}
	
	private StringBuffer data = new StringBuffer();
}
