package net.azib.java.students.t030633.hometasks.copier;

import java.nio.ByteBuffer;

/**
 * DirectChanneledCopyProgram
 * 
 * @author t030633
 */
public class DirectChanneledCopyProgram extends AbstractChanneledCopyProgram {

	public DirectChanneledCopyProgram() {
		super();
	}

	public DirectChanneledCopyProgram(int capacity) {
		super(capacity);
	}

	protected ByteBuffer allocateBuffer(int capacity) {
		return ByteBuffer.allocateDirect(capacity);
	}

}
