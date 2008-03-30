package net.azib.java.students.t040719.lessons;

import java.nio.ByteBuffer;

/**
 * DirectChannelledCopyProgram
 *
 * @author romi
 */
public class DirectChannelledCopyProgram extends AbstractChanneledCopyProgram {
	private int cap;
	public DirectChannelledCopyProgram(int cap) {
		this.cap = cap;
	}
	@Override
	public ByteBuffer allocateBuffer() {
		return ByteBuffer.allocateDirect(cap);
	}
}
