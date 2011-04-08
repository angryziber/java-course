package net.azib.java.students.t104971.streams;

import org.junit.Test;

import java.io.*;

/**
 * @author Jaroslav Judin
 */
public class BufferedCopyProgramTest {
    @Test
    public void testCopy() throws Exception {
        BufferedCopyProgram copyProgram = new BufferedCopyProgram();
        InputStream inputStream = BufferedCopyProgram.class.getResourceAsStream("karate_kid.jpg");
        OutputStream outputStream = new FileOutputStream("test_out.jpg");

        copyProgram.copy(inputStream, outputStream);
    }
}
