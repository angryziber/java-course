package net.azib.java.students.t030633;

import java.nio.ByteBuffer;

/**
 * DirectChanneledCopyProgram
 * 
 * @author t030633
 */
public class DirectChanneledCopyProgram extends AbstractChanneledCopyProgram {

	protected ByteBuffer allocateBuffer(int capacity) {
		return ByteBuffer.allocateDirect(capacity);
	}

}
