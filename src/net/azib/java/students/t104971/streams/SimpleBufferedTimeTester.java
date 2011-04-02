package net.azib.java.students.t104971.streams;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;

/**
 * @author Jaroslav Judin
 */
public class SimpleBufferedTimeTester {

    public static void main(String[] args) throws IOException {
        measureTime(new SimpleCopyProgram(), new File("trunk/build.xml"), File.createTempFile("dummy", null));
        measureTime(new BufferedCopyProgram(), new File("trunk/build.xml"), File.createTempFile("dummy", null));
        measureTime(new UtilCopyProgram(), new File("trunk/build.xml"), File.createTempFile("dummy", null));
    }

    private static long measureTime(FileCopier copier, File f1, File f2) throws IOException {
        long start = System.currentTimeMillis();
        copier.copy(f1, f2);
        long time = System.currentTimeMillis() - start;
        System.out.println("Spent time on " + copier.getClass().getSimpleName() + " copy: " + time);
        return time;
    }
}
