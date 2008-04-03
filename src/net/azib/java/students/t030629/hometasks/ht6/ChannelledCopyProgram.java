package net.azib.java.students.t030629.hometasks.ht6;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.ByteBuffer;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 19:12:07
 */
public class ChannelledCopyProgram extends AbstractFileCopier {
    static final String NEGATIVE_BUFFER_SIZE_TEXT = "Buffer capacity is a negative number: ";
    private static final int DEFAULT_CAPACITY = 8192;
    protected final int bufCapacity;

    public ChannelledCopyProgram(int bufCapacity) {
        if (bufCapacity < 0) throw new IllegalArgumentException(NEGATIVE_BUFFER_SIZE_TEXT + bufCapacity);
        this.bufCapacity = bufCapacity;
    }

    public ChannelledCopyProgram() {
        bufCapacity = DEFAULT_CAPACITY;
    }

    public void copy(InputStream src, OutputStream dest) throws IOException {
        validateStreams(src, dest);
        ReadableByteChannel readChannel = null;
        WritableByteChannel writeChannel = null;

        try {
            readChannel = Channels.newChannel(src);
            writeChannel = Channels.newChannel(dest);
            ByteBuffer buffer = allocateBuffer();

            do {
                /* Prepare buffer for writing into it */
                buffer.clear();
                /* Read from channel into buffer, check for end-of-stream */
                if (readChannel.read(buffer) == -1)
                    break;
                /* Prepare buffer for reading from it */
                buffer.flip();
                /* Write to channel from buffer */
                writeChannel.write(buffer);
            } while (true);
        } finally {
            QuietCloser.closeQuietly(readChannel);
            QuietCloser.closeQuietly(writeChannel);
        }
    }

    protected ByteBuffer allocateBuffer(){
        return ByteBuffer.allocate(bufCapacity);
    }
}
