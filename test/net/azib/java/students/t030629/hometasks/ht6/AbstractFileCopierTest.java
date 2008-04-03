package net.azib.java.students.t030629.hometasks.ht6;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.easymock.classextension.EasyMock.*;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 31.03.2008
 * <br>Time: 14:48:19
 */
public abstract class AbstractFileCopierTest {

    protected AbstractFileCopier copier;
    private byte[] testBytes = {9, 7, 3, 5, 2, 1};

    /**
     * <html>
     * IntelliJ IDEA bug <A href="http://www.jetbrains.net/jira/browse/IDEA-17579">17579</A> <br>
     * <u>Bug report date</u>: Sun Mar 30 15:54 EEST 2008
     * <br><br>
     * <u>Description</u>: The JUnit test runner doesn't pick up test classes that extend parent test class.<br>
     * As a result, the proposed solution to initialize the concrete copier in AbstractFileCopier
     * constructor can not be implemented in IntelliJ until this bug is fixed. At the same time, Eclipse
     * does support such kind of generic tests without a problem.
     * <br><br>
     * <u>Work around</u>:<br>
     * 1) Replace constructor with an abstract {@link #initCopier()} method annotated with
     * {@link org.junit.Before} that should be implemented by each of the subclasses.<br>
     * 2) Override generic test methods in subclasses by simply calling their parent
     * implementations.
     * <br><br>
     * todo: As soon as the bug above is resolved, replace all overriden methods
     * in subclasses of this class with a constructor that creates a concrete implementation
     * of AbstractFileCopier and remove {@link #initCopier()} method.
     * </html>
     */
    @Before
    public abstract void initCopier();

    /* #######################################################
     * ####### T E S T   I N P U T   P A R A M E T E R S #####
     * ####################################################### */
    @Test (expected = NullPointerException.class)
    public void nullPointerExceptionThrownForSourceFile() throws IOException {
        copyFiles(null, mockExistentFile());
    }

    @Test (expected = NullPointerException.class)
    public void nullPointerExceptionThrownForDestFile() throws IOException {
        copyFiles(mockExistentFile(), null);
    }

    @Test (expected = NullPointerException.class)
    public void nullPointerExceptionThrownForSourceStream() throws IOException {
        copyStreams(null, mockOutputStream());
    }

    private OutputStream mockOutputStream() {
        return new OutputStream(){
            public void write(int b) throws IOException {}
        };
    }

    @Test (expected = NullPointerException.class)
    public void nullPointerExceptionThrownForDestStream() throws IOException {
        copyStreams(mockInputStream(), null);
    }

    private InputStream mockInputStream() {
        return new InputStream() {
            public int read() throws IOException { return 0; }
        };
    }

    private File mockExistentFile() {
        File mockFile = createMock(File.class);
        expect(mockFile.exists()).andReturn(true);
        replay(mockFile);
        return mockFile;
    }

    @Test (expected = FileNotFoundException.class)
    public void fileNotFoundExceptionThrownForSourceFile() throws IOException {
        copyFiles(mockNonexistentFile(), mockExistentFile());
    }

    private File mockNonexistentFile() {
        File mockSrcFile = createMock(File.class);
        expect(mockSrcFile.exists()).andReturn(false);
        replay(mockSrcFile);
        return mockSrcFile;
    }

    @Test
    public void correctMessageForNullPointerException() throws IOException {
        /* Test SOURCE */
        try {
            copyFiles(null, mockExistentFile());
        } catch (NullPointerException e) {
            assertEquals(AbstractFileCopier.NULL_POINTER_TEXT, e.getMessage());
        }
        try {
            copyStreams(null, mockOutputStream());
        } catch (NullPointerException e) {
            assertEquals(AbstractFileCopier.NULL_POINTER_TEXT, e.getMessage());
        }
        /* Test DESTINATION */
        try {
            copyFiles(mockExistentFile(), null);
        } catch (NullPointerException e) {
            assertEquals(AbstractFileCopier.NULL_POINTER_TEXT, e.getMessage());
        }
        try {
            copyStreams(mockInputStream(), null);
        } catch (NullPointerException e) {
            assertEquals(AbstractFileCopier.NULL_POINTER_TEXT, e.getMessage());
        }
    }

    @Test
    public void correctMessageForFileNotFoundException() throws IOException {
        /* Test SOURCE */
        try {
            copyFiles(mockNonexistentFile(), mockExistentFile());
        } catch (FileNotFoundException e) {
            assertEquals(AbstractFileCopier.MISSING_SOURCE_TEXT, e.getMessage());
        }
    }

    /* #######################################################
     * ####### T E S T   F U N C T I O N A L I T Y  ##########
     * ####################################################### */

    @Test
    public void copyStreamWorks() throws IOException {

        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new ByteArrayInputStream(testBytes);
            out = new ByteArrayOutputStream();

            copyStreams(in, out);
            /* Compare arrays */
            byte[] copiedBytes = out.toByteArray();
            assertEquals("Number of bytes in destination stream differs from that in source stream",
                    testBytes.length, copiedBytes.length);
            for (int i = 0; i < testBytes.length; i++) {
                assertTrue(testBytes[i] == copiedBytes[i]);
            }
        } finally {
            QuietCloser.closeQuietly(in);
            QuietCloser.closeQuietly(out);
        }

    }

    @Test
    public void copyFilesWorks() throws IOException {

        List<Byte> readBytesList = new ArrayList<Byte>(testBytes.length);
        File srcFile = File.createTempFile("TestCopyProgram", null);
        File destFile = File.createTempFile("TestCopyProgram_COPY", null);
        srcFile.deleteOnExit(); destFile.deleteOnExit();
        
        /* Write test bytes to the temp SOURCE file in temp dir */
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(srcFile);
            fos.write(testBytes);
        } finally {
            QuietCloser.closeQuietly(fos);
        }

        /* Copy file */
        copyFiles(srcFile, destFile);

        /* Read copied file */
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(destFile);
            byte aByte;
            while ((aByte = (byte) fis.read()) != -1) {
                readBytesList.add(aByte);
            }
        } finally {
            QuietCloser.closeQuietly(fis);
        }
        /* Compare arrays */
        assertEquals("Number of bytes in destination file differs from that in source file",
                testBytes.length, readBytesList.size());
        for (int i = 0; i < testBytes.length; i++) {
            assertTrue(testBytes[i] == readBytesList.get(i));
        }

    }


    private void copyFiles(File src, File dest) throws IOException {
        copier.copy(src, dest);
    }

    private void copyStreams(InputStream src, OutputStream dest) throws IOException {
        copier.copy(src, dest);
    }


}
