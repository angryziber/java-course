package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.io.FileCopier;
import net.azib.java.students.t040719.lessons.old.BufferedCopyProgram;
import net.azib.java.students.t040719.lessons.old.SimpleCopyProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * LessonSix
 *
 * @author romi
 */
public class LessonSix {
	public static long measureRunTime(Runnable runnable){
		long t = System.currentTimeMillis();
		runnable.run();
		return System.currentTimeMillis()-t;
	}
	
	public static void main(String[] args) {
		//FileCopier fc = new SimpleCopyProgram();
		String in = "D:\\test.jpg";
		String out = "D:\\out.file";
		System.out.println("Copy without buffer took " + measureRunTime(new SimpleCopyProgram(new File(in), new File(out))) +" ms");
		System.out.println("Copy with buffering took " + measureRunTime(new BufferedCopyProgram(new File(in), new File(out))) +" ms");
		/*try {
			fc.copy(new File("D:\\sisend.jpg"), new File("D:\\valjund.jpg"));
		}
		catch (FileNotFoundException e){
			System.out.println("File not found!");
		}
		catch (IOException e) {
			System.out.println("Unknown exception: "+e.toString());
		}*/
	}
}
