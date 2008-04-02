package net.azib.java.students.t030633.hometasks.copier;

import java.nio.ByteBuffer;

/**
 * ChanneledCopyProgram
 * 
 * @author t030633
 */
public class ChanneledCopyProgram extends AbstractChanneledCopyProgram {

	protected ByteBuffer allocateBuffer(int capacity) {
		return ByteBuffer.allocate(capacity);
	}

}
