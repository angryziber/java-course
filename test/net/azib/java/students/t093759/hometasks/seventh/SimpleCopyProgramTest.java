package net.azib.java.students.t093759.hometasks.seventh;

/**
 * @author dionis
 *         4/7/11 9:01 AM
 */
public class SimpleCopyProgramTest extends FileAndDataCopierTest {

	@Override
	protected FileAndDataCopier getCopyProgram() {
		return new SimpleCopyProgram();
	}
}
