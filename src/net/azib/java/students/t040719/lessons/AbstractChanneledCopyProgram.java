package net.azib.java.students.t040719.lessons;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;


/**
 * AbstractChanneledCopyProgram
 *
 * @author romi
 */
public abstract class AbstractChanneledCopyProgram extends AbstractCopier {
	private ByteBuffer buf;
	
	public abstract ByteBuffer allocateBuffer();
	
	@Override
	public void copy(InputStream src, OutputStream dest) throws IOException {
		ReadableByteChannel rc = Channels.newChannel(src);
		WritableByteChannel wc = Channels.newChannel(dest);
		
		buf = allocateBuffer();

		buf.clear();
		rc.read(buf);
		while(buf.capacity()!=buf.remaining()){
			buf.flip();
			wc.write(buf);
			buf.clear();
			rc.read(buf);
		}
		rc.close();
		wc.close();
	}

}
