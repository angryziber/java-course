package net.azib.java.students.t030629.hometasks.ht6;

import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 24.03.2008
 * <br>Time: 0:25:32
 */
public class BufferedCopyProgram extends AbstractFileCopier {

    protected OutputStream wrapOutputStream(OutputStream dest) {
        return new BufferedOutputStream(dest);
    }

    protected InputStream wrapInputStream(InputStream src) {
        return new BufferedInputStream(src);
    }

}
