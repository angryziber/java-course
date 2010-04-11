package net.azib.java.students.t092875.hw5;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;

/**
 * CopyRunner
 *
 * @author Mihhail
 */
public class CopyRunner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new CopyRunner().run();
	}
	
	public void run() throws IOException{
		FileCopier copier = new SimpleCopyProgram();
		File parent = new File(new File(".."), "java");
		File source = new File(parent, "src.txt");
		File distination = new File(parent, "somefile.txt");
		File distination2 = new File(parent, "somefile2.txt");
		if(!distination.exists()){
			distination.createNewFile();
		}
		if(!distination2.exists()){
			distination.createNewFile();
		}
		long start = System.currentTimeMillis();
		copier.copy(source, distination);
		System.out.println(System.currentTimeMillis()-start);
		
		copier = new BufferedCopyProgram();
		start = System.currentTimeMillis();
		copier.copy(source, distination2);
		System.out.println(System.currentTimeMillis()-start);
	}

}
