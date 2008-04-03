package net.azib.java.students.t030629.hometasks.ht6;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 20:24:36
 */
public class DirectChannelledCopyProgramTest extends ChannelledCopyProgramTest {

    @Before
    public void initCopier() {
        copier = new DirectChannelledCopyProgram();
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownForSourceFile() throws IOException {
        super.nullPointerExceptionThrownForSourceFile();
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownForDestFile() throws IOException {
        super.nullPointerExceptionThrownForDestFile();
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundExceptionThrownForSourceFile() throws IOException {
        super.fileNotFoundExceptionThrownForSourceFile();
    }

    @Test
    public void correctMessageForFileNotFoundException() throws IOException {
        super.correctMessageForFileNotFoundException();
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownForSourceStream() throws IOException {
        super.nullPointerExceptionThrownForSourceStream();
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownForDestStream() throws IOException {
        super.nullPointerExceptionThrownForDestStream();
    }

    @Test
    public void correctMessageForNullPointerException() throws IOException {
        super.correctMessageForNullPointerException();
    }

    @Test
    public void copyStreamWorks() throws IOException {
        super.copyStreamWorks();
    }

    @Test
    public void copyFilesWorks() throws IOException {
        super.copyFilesWorks();
    }
}
