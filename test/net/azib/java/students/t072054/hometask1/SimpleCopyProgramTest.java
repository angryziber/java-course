package net.azib.java.students.t072054.hometask1;

import net.azib.java.students.t030629.hometasks.ht4.Circle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.File;

import org.junit.Test;

/**
 * SimpleCopyProgramTest
 * 
 * @author r_vassiljev
 */
public class SimpleCopyProgramTest {

    public static boolean filesAreIdentical(File left, File right) throws IOException
    {
        assert left != null;
        assert right != null;
        assert left.exists();
        assert right.exists();
        
        if (left.length() != right.length())
            return false;
        
        FileInputStream lin = new FileInputStream(left);
        FileInputStream rin = new FileInputStream(right);
        try
        {
            byte[] lbuffer = new byte[4096];
            byte[] rbuffer = new byte[lbuffer.length];
            for (int lcount = 0; (lcount = lin.read(lbuffer)) > 0;)
            {
                int bytesRead = 0;
                for (int rcount = 0; (rcount = rin.read(rbuffer, bytesRead, lcount - bytesRead)) > 0;)
                {
                    bytesRead += rcount;
                }
                for (int byteIndex = 0; byteIndex < lcount; byteIndex++)
                {
                    if (lbuffer[byteIndex] != rbuffer[byteIndex])
                        return false;
                }
            }
        }
        finally
        {
            lin.close();
            rin.close();
        }
        return true;
    }


	
	/**
	 * Test method for SimpleCopyProgram
	 */
	@Test
	public void functionalityTest() {
		File f1 = new File("C:\\source.txt");
		File f2 = new File("C:\\dest.txt");
		long time_start, time_end;
		
		SimpleCopyProgram scp = new SimpleCopyProgram();

		try {
			time_start = System.currentTimeMillis();
			scp.copy(f1, f2);
			time_end = System.currentTimeMillis();
			
			System.out.println(time_end - time_start);
			
			assertTrue(filesAreIdentical(f1, f2));
		}
		catch (Exception e) {
			System.out.println("File exception");
		}
	}
}
