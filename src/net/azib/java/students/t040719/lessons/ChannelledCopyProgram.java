package net.azib.java.students.t040719.lessons;

import java.nio.ByteBuffer;

/**
 * ChannelledCopyProgram
 *
 * @author romi
 */
public class ChannelledCopyProgram extends AbstractChanneledCopyProgram {
	private int cap;
	public ChannelledCopyProgram(int cap) {
		this.cap = cap;
	}
	@Override
	public ByteBuffer allocateBuffer() {
		return ByteBuffer.allocate(cap);
	}
}
