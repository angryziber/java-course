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
		
		int out = -1;
		if(!data.isEmpty()){
			out = (int)data.charAt(0);
			data = data.substring(1);
		}
		return out;
	}

	public void write(String b){
		data += b;
	}
	
	private String data = "";
}
