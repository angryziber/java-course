package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;

/**
 * PerformanceTimer
 *
 * @author Karl
 */
public class PerformanceTimer {

	public static long measureTime(FileCopier copier, File src, File dest) throws IOException {
		long t = System.currentTimeMillis();
		copier.copy(src, dest);
		return System.currentTimeMillis() - t;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		String nameOfSourceFile = args[0];
		FileCopier unbufferedCopier = new SimpleCopyProgram();
		FileCopier bufferedCopier = new BufferedCopyProgram();
		File sourceFile = new File(nameOfSourceFile);
		long unbufferedProgramTime;
		try {
			unbufferedProgramTime = measureTime(unbufferedCopier, sourceFile, new File("toUnbuffered.txt"));
			long bufferedProgramTime = measureTime(bufferedCopier, sourceFile, new File("toBuffered.txt"));
			System.out.println("Unbuffered copying took time " + unbufferedProgramTime + " milliseconds");
			System.out.println("Buffered copying took time " + bufferedProgramTime + " milliseconds");
			long difference = unbufferedProgramTime - bufferedProgramTime;
			long sourceFileSize = sourceFile.length();
			System.out.println("Difference between unbuffered and buffered file (" + sourceFileSize + " bytes) copying is " + difference + " milliseconds");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
