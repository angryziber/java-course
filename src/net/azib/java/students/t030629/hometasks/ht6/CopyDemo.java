package net.azib.java.students.t030629.hometasks.ht6;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 03.04.2008
 * <br>Time: 22:07:56
 */
public class CopyDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IOException {
        CopyPerformanceTimer performanceTimer = new CopyPerformanceTimer();

        if (args.length == 3) {
            /* Copy with REQUESTED method */
            File src = new File(args[0]);
            File dest = new File(args[1]);
            CopyingMethod copyingMethod = CopyingMethod.valueOf(args[2]);

            FileCopier copyProgram = copyingMethod.copyProgramClass.getConstructor().newInstance();
            performanceTimer.doMeasure(copyProgram, src, dest);
            System.out.println("Copying done with " + copyingMethod.copyProgramClass.getSimpleName() + "!");
            System.out.println("File size: " + normalizedLengthAsString(src));

        } else if (args.length == 2) {
            /* Copy with all methods */
            File src = new File(args[0]);
            StringBuilder destFileNameBuilder;
            for (CopyingMethod method : CopyingMethod.values()) {
                destFileNameBuilder = new StringBuilder(args[1]);
                int lastDotIndex = destFileNameBuilder.lastIndexOf(".");
                File dest = new File(destFileNameBuilder.insert(lastDotIndex, "_" + method).toString());
                FileCopier copyProgram = method.copyProgramClass.getConstructor().newInstance();
                performanceTimer.doMeasure(copyProgram, src, dest);
                System.out.println("Copying done with " + method.copyProgramClass.getSimpleName() + "!");
            }
            System.out.println("File size: " + normalizedLengthAsString(src));
        } else {
            System.out.println("Either 2 or 3 arguments expected:\n" +
                    "1) To test ALL copying methods: source file, destination file\n" +
                    "2) To test ONE copying method: source file, destination file, copying method " +
                    "( <C> - Channelled, <D> - Direct, <M> - Mapping, <S> - Simple, <B> - Buffered )");
        }
    }

    private static String normalizedLengthAsString(File src) {
        int factorK = 1000;
        int factorM = 1000000;
        int factorG = 1000000000;

        long size = src.length();
        if (size < factorK) {
            return size + " B";
        } else if (size < factorM) {
            return size / factorK + " KB";
        } else if (size < factorG) {
            return size / factorM + " MB";
        } else {
            return size / factorG + " GB";
        }

    }

    private enum CopyingMethod {
        C(ChannelledCopyProgram.class),
        D(DirectChannelledCopyProgram.class),
        M(MappingCopyProgram.class),
        S(SimpleCopyProgram.class),
        B(BufferedCopyProgram.class);

        private Class<? extends FileCopier> copyProgramClass;

        CopyingMethod(Class<? extends FileCopier> copyProgramClass) {
            this.copyProgramClass = copyProgramClass;
        }
    }

}


/*
##############  S T A T I S T I C S  #############
##################################################
BUFFER for C and D: 8192
File: D:\TEMPORARY\BlueCanary_1988_.rar
File size: 45 MB

Duration: 1437ms
Copying done with ChannelledCopyProgram!
Duration: 2969ms
Copying done with DirectChannelledCopyProgram!
Duration: 2641ms
Copying done with MappingCopyProgram!

Duration: 1390ms
Copying done with ChannelledCopyProgram!
Duration: 2844ms
Copying done with DirectChannelledCopyProgram!
Duration: 2640ms
Copying done with MappingCopyProgram!

Duration: 1141ms
Copying done with ChannelledCopyProgram!
Duration: 2281ms
Copying done with DirectChannelledCopyProgram!
Duration: 2875ms
Copying done with MappingCopyProgram!

Duration: 1110ms
Copying done with ChannelledCopyProgram!
Duration: 3203ms
Copying done with DirectChannelledCopyProgram!
Duration: 2812ms
Copying done with MappingCopyProgram!

Duration: 1546ms
Copying done with ChannelledCopyProgram!
Duration: 1188ms
Copying done with DirectChannelledCopyProgram!
Duration: 3391ms
Copying done with MappingCopyProgram!
Duration: 217687ms
Copying done with SimpleCopyProgram!
Duration: 1922ms
Copying done with BufferedCopyProgram!

##### From this point forward - without SimpleCopyProgram #####
Duration: 1875ms
Copying done with ChannelledCopyProgram!
Duration: 2437ms
Copying done with DirectChannelledCopyProgram!
Duration: 3266ms
Copying done with MappingCopyProgram!
Duration: 1703ms
Copying done with BufferedCopyProgram!

Duration: 1625ms
Copying done with ChannelledCopyProgram!
Duration: 2954ms
Copying done with DirectChannelledCopyProgram!
Duration: 3781ms
Copying done with MappingCopyProgram!
Duration: 1687ms
Copying done with BufferedCopyProgram!

##### From this point forward - BUFFER for C and D: 32K (2^15 = 32768) #####
Duration: 2391ms
Copying done with ChannelledCopyProgram!
Duration: 859ms
Copying done with DirectChannelledCopyProgram!
Duration: 3422ms
Copying done with MappingCopyProgram!
Duration: 1781ms
Copying done with BufferedCopyProgram!

Duration: 1782ms
Copying done with ChannelledCopyProgram!
Duration: 3234ms
Copying done with DirectChannelledCopyProgram!
Duration: 3281ms
Copying done with MappingCopyProgram!
Duration: 1735ms
Copying done with BufferedCopyProgram!

Duration: 1438ms
Copying done with ChannelledCopyProgram!
Duration: 3406ms
Copying done with DirectChannelledCopyProgram!
Duration: 3453ms
Copying done with MappingCopyProgram!
Duration: 1703ms
Copying done with BufferedCopyProgram!

##################################################
File: D:\TEMPORARY\BlueCanary_1988_x\ - Blue Canary (x, 1988).avi
File size: 44 MB
Buf: 8192

Duration: 4172ms
Copying done with ChannelledCopyProgram!
Duration: 2125ms
Copying done with DirectChannelledCopyProgram!
Duration: 3891ms
Copying done with MappingCopyProgram!

Duration: 1250ms
Copying done with ChannelledCopyProgram!
Duration: 2812ms
Copying done with DirectChannelledCopyProgram!
Duration: 3985ms
Copying done with MappingCopyProgram!

Duration: 1296ms
Copying done with ChannelledCopyProgram!
Duration: 2984ms
Copying done with DirectChannelledCopyProgram!
Duration: 3610ms
Copying done with MappingCopyProgram!

Duration: 1594ms
Copying done with ChannelledCopyProgram!
Duration: 2750ms
Copying done with DirectChannelledCopyProgram!
Duration: 3625ms
Copying done with MappingCopyProgram!

Duration: 1468ms
Copying done with ChannelledCopyProgram!
Duration: 2969ms
Copying done with DirectChannelledCopyProgram!
Duration: 3922ms
Copying done with MappingCopyProgram!

##################################################
File: D:\Documents and Settings\Randy\My Documents\Anton\TTU\4 Kursus - MAGISTER\4 Semester\Java KEKS\1-introduction.pdf
File size: 898 KB
Buf: 8192

Duration: 15ms
Copying done with ChannelledCopyProgram!
Duration: 0ms
Copying done with DirectChannelledCopyProgram!
Duration: 16ms
Copying done with MappingCopyProgram!
Duration: 4313ms
Copying done with SimpleCopyProgram!
Duration: 31ms
Copying done with BufferedCopyProgram!


Duration: 16ms
Copying done with ChannelledCopyProgram!
Duration: 15ms
Copying done with DirectChannelledCopyProgram!
Duration: 31ms
Copying done with MappingCopyProgram!
Duration: 4297ms
Copying done with SimpleCopyProgram!
Duration: 32ms
Copying done with BufferedCopyProgram!


Duration: 16ms
Copying done with ChannelledCopyProgram!
Duration: 0ms
Copying done with DirectChannelledCopyProgram!
Duration: 31ms
Copying done with MappingCopyProgram!
Duration: 4297ms
Copying done with SimpleCopyProgram!
Duration: 47ms
Copying done with BufferedCopyProgram!


Duration: 16ms
Copying done with ChannelledCopyProgram!
Duration: 16ms
Copying done with DirectChannelledCopyProgram!
Duration: 31ms
Copying done with MappingCopyProgram!
Duration: 4281ms
Copying done with SimpleCopyProgram!
Duration: 31ms
Copying done with BufferedCopyProgram!


Duration: 16ms
Copying done with ChannelledCopyProgram!
Duration: 16ms
Copying done with DirectChannelledCopyProgram!
Duration: 15ms
Copying done with MappingCopyProgram!
Duration: 4313ms
Copying done with SimpleCopyProgram!
Duration: 47ms
Copying done with BufferedCopyProgram!

*/

