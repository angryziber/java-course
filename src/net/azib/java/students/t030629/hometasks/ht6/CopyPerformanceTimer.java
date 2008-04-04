package net.azib.java.students.t030629.hometasks.ht6;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 24.03.2008
 * <br>Time: 0:28:27
 */
public class CopyPerformanceTimer {

    private long measure(Runnable runnable){
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
    }

     public void doMeasure(final FileCopier fileCopier, final File src, final File dest){
        long duration = new CopyPerformanceTimer().measure(new Runnable() {
            public void run() {
                try {
                    fileCopier.copy(src, dest);
                } catch (IOException e) {/* Do nothing. Exception is guaranteed not to be thrown here. */}
            }
        });
        
        System.out.println("Duration: " + duration + "ms");
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
//        final File src = new File("D:\\Documents and Settings\\Randy\\My Documents\\Anton\\TTU\\4 Kursus - MAGISTER\\4 Semester\\Java KEKS\\1-introduction.pdf");
//        final File dest1 = new File("D:\\Documents and Settings\\Randy\\My Documents\\Anton\\TTU\\4 Kursus - MAGISTER\\4 Semester\\Java KEKS\\1-introduction_COPY.pdf");
//        final File dest2 = new File("D:\\Documents and Settings\\Randy\\My Documents\\Anton\\TTU\\4 Kursus - MAGISTER\\4 Semester\\Java KEKS\\1-introduction_COPY2.pdf");
        final File src = new File(CopyPerformanceTimer.class.getResource("/java-logo.gif").toURI());
        final File dest1 = File.createTempFile("java-logo_PERFORMANCE_COPY_1_", ".gif");
        final File dest2 = File.createTempFile("java-logo_PERFORMANCE_COPY_2_", ".gif");

        new CopyPerformanceTimer().doMeasure(new SimpleCopyProgram(), src, dest1);
        new CopyPerformanceTimer().doMeasure(new BufferedCopyProgram(), src, dest2);

        dest1.delete();
        dest2.delete();
    }

}
