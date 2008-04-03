package net.azib.java.students.t030629.hometasks.ht6;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.assertEquals;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 19:28:09
 */
public class ChannelledCopyProgramTest extends AbstractFileCopierTest {

    /**
     * @see AbstractFileCopierTest#initCopier()
     */
    @Before
    public void initCopier() {
        copier = new ChannelledCopyProgram();
    }

    @Test (expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionThrownForNegativeBufferSize() throws Throwable, IllegalAccessException, InstantiationException {
        try {
            copier.getClass().getConstructor(int.class).newInstance(-1);
        } catch (InvocationTargetException e) {
            /* Ignore InvocationTargetException, which is thrown if the underlying contructor
             * throws an exception. The latter is forced to throw an IllegalArgumentException.
             * So rethrow the target exception. */
            throw e.getCause();
        }
    }

    @Test
    public void correctMessageForIllegalArgumentException() throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        try {
            copier.getClass().getConstructor(int.class).newInstance(-1);
        } catch (InvocationTargetException e) {
            assertEquals(ChannelledCopyProgram.NEGATIVE_BUFFER_SIZE_TEXT + "-1", e.getCause().getMessage());
        }
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