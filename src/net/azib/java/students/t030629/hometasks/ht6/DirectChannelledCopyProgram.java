package net.azib.java.students.t030629.hometasks.ht6;

import java.nio.ByteBuffer;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 20:14:31
 */
public class DirectChannelledCopyProgram extends ChannelledCopyProgram {

    public DirectChannelledCopyProgram(int bufCapacity) {
        super(bufCapacity);
    }

    public DirectChannelledCopyProgram() {
        super();
    }

    protected ByteBuffer allocateBuffer() {
        return ByteBuffer.allocateDirect(bufCapacity);
    }
}
