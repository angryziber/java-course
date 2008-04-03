package net.azib.java.students.t030629.hometasks.ht6;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 21:07:12
 */
public class MappingCopyProgram extends ChannelledCopyProgram {

    public MappingCopyProgram(int bufCapacity) {
        super(bufCapacity);
    }

    public MappingCopyProgram() {
        super();
    }

    public void copy(File src, File dest) throws IOException {
        validateFiles(src, dest);
        FileChannel readChannel = null;
        FileChannel writeChannel = null;
        try {
            readChannel = new FileInputStream(src).getChannel();
            writeChannel = new RandomAccessFile(dest, "rw").getChannel();

            /* Map the whole source file into memory
             * and allocate space for destination buffer */
            MappedByteBuffer readBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
            MappedByteBuffer writeBuffer = writeChannel.map(FileChannel.MapMode.READ_WRITE, 0, readChannel.size());
            /* Copy data from one buffer to another */
            writeBuffer.put(readBuffer);
            writeBuffer.force();
        } finally {
            QuietCloser.closeQuietly(readChannel);
            QuietCloser.closeQuietly(writeChannel);
        }
    }

}
