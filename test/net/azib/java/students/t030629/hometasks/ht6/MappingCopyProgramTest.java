package net.azib.java.students.t030629.hometasks.ht6;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 21:49:33
 */
public class MappingCopyProgramTest extends ChannelledCopyProgramTest {

    /**
     * NB! One test method has been added to make IntelliJ automatically add all parent test methods. 
     * @see AbstractFileCopierTest#initCopier()
     */
    @Before
    public void initCopier() {
        copier = new MappingCopyProgram();
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerExceptionThrownForSourceFile() throws IOException {
        super.nullPointerExceptionThrownForSourceFile();
    }

}
