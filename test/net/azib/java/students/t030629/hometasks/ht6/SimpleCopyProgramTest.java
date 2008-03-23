package net.azib.java.students.t030629.hometasks.ht6;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 23.03.2008
 * <br>Time: 22:42:32
 */
public class SimpleCopyProgramTest {

    @Test (expected = NullPointerException.class)
    public void testNullSourceFile() throws IOException {
        copyFiles(null, new File(""));
    }

    @Test (expected = NullPointerException.class)
    public void testNullDestFile() throws IOException {
        copyFiles(new File(""), null);
    }

    @Test (expected = FileNotFoundException.class)
    public void testMissingSourceFile() throws IOException {
        copyFiles(new File("someNonexistentFile"), new File(""));
    }

    private void copyFiles(File src, File dest) throws IOException {
        new SimpleCopyProgram().copy(src, dest);
    }

}
