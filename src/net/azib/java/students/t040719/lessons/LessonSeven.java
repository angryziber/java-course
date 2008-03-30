package net.azib.java.students.t040719.lessons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * LessonSeven
 *
 * @author romi
 */
public class LessonSeven {
	static final String SEP = File.separator;
	public static void main(String[] args) throws IOException {
		File out = File.createTempFile("outTest", ".file");
		URI src = null;
		URL test = null;
		OutputStream os = new FileOutputStream(out);
		try {
			src = new URI(LessonSeven.class.getClassLoader().getResource("net"+SEP+"azib"+SEP+"java"+SEP+"students"+SEP+"t040719"+SEP+"lessons"+SEP+"test.file").toString());
		}
		catch (URISyntaxException e) {
			System.err.println("Couldn't find the source file.");
		}
		test = src.toURL();
		System.out.println("Testing " + SimpleCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new SimpleCopyProgram(), new File(src), out));
		System.out.println("Testing " + BufferedCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new BufferedCopyProgram(), new File(src), out));
		System.out.println("Testing via URL " + SimpleCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new SimpleCopyProgram(), test.openConnection().getInputStream(), os));
		System.out.println("Testing via URL " + BufferedCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new BufferedCopyProgram(), test.openStream(), os));
		System.out.println("Testing " + ChannelledCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new ChannelledCopyProgram(10), new File(src), out));
		System.out.println("Testing " + DirectChannelledCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new DirectChannelledCopyProgram(10), new File(src), out));
		System.out.println("Testing " + MappingCopyProgram.class.getSimpleName() + ": " + CopyPerformanceTimer.measureTime(new MappingCopyProgram(), new File(src), out));
		out.delete();
	}
}
