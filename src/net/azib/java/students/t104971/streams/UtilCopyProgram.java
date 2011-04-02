package net.azib.java.students.t104971.streams;

import net.azib.java.lessons.io.FileCopier;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Jaroslav Judin
 */
public class UtilCopyProgram implements FileCopier {
    @Override
    public void copy(File f1, File f2) throws IOException {
        FileUtils.copyFile(f1, f2);
    }
}
