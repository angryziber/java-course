package net.azib.java.students.t092860.homework;

import java.io.IOException;
import java.io.InputStream;

/**
 * InputStreamMock
 *
 * @author armin
 */
public class InputStreamMock extends InputStream {

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void write(String b){
		data.append(b);
	}
	
	private StringBuffer data = new StringBuffer();
}
