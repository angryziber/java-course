package net.azib.java.students.t030629.hometasks.ht6;

import net.azib.java.lessons.io.FileCopier;
import net.azib.java.lessons.io.DataCopier;

import java.io.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 31.03.2008
 * <br>Time: 14:31:31
 */
public abstract class AbstractFileCopier implements FileCopier, DataCopier {
    static final String NULL_POINTER_TEXT = NullPointerException.class.getSimpleName() + " for src or dest object";
    static final String MISSING_SOURCE_TEXT = "src file is not found";

    public void copy(File src, File dest) throws IOException {
        validateFiles(src, dest);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            copy(in, out);
        } finally {
            QuietCloser.closeQuietly(in);
            QuietCloser.closeQuietly(out);
        }

    }

    private void validateFiles(File src, File dest) throws FileNotFoundException {
        if (src == null || dest == null) throw new NullPointerException(NULL_POINTER_TEXT);
        if (!src.exists()) throw new FileNotFoundException(MISSING_SOURCE_TEXT);
    }

    private void validateStreams(InputStream src, OutputStream dest) {
        if (src == null || dest == null) throw new NullPointerException(NULL_POINTER_TEXT);
    }

    protected OutputStream wrapOutputStream(OutputStream dest) {
        return dest;
    }

    protected InputStream wrapInputStream(InputStream src) {
        return src;
    }

    public void copy(InputStream src, OutputStream dest) throws IOException {
        validateStreams(src, dest);

        src = wrapInputStream(src);
        dest = wrapOutputStream(dest);

        int aChar;
        while ((aChar = src.read()) != -1) {
            dest.write(aChar);
        }

        dest.flush();        
    }
}
