package net.azib.java.students.t030633;

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
 * @author t030633
 */
public abstract class AbstractChanneledCopyProgram extends AbstractFileCopier {

	private static final int DEFAULT_CAPACITY = 8;
	private ByteBuffer buffer;
	private int capacity; // buffer capacity in bytes

	public AbstractChanneledCopyProgram() {
		this(DEFAULT_CAPACITY);
	}

	public AbstractChanneledCopyProgram(int capacity) {
		this.capacity = capacity;
	}

	protected abstract ByteBuffer allocateBuffer(int capacity);

	public void copy(InputStream src, OutputStream dest) throws IOException {

		buffer = allocateBuffer(capacity);

		ReadableByteChannel readChannel = Channels.newChannel(src);
		WritableByteChannel writeChannel = Channels.newChannel(dest);

		while (true) {
			buffer.clear();
			readChannel.read(buffer);
			if (buffer.remaining() == buffer.capacity())
				break;
			buffer.flip();
			writeChannel.write(buffer);
		}

		readChannel.close();
		writeChannel.close();

	}

}
