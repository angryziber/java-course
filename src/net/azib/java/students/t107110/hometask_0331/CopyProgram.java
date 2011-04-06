package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Eduard Shustrov
 */
public class CopyProgram {
	enum CopyingMethod {
		SIMPLE {
			@Override
			public FileCopier getFileCopier() {
				return new SimpleCopyProgram();
			}
		},
		BUFFERED {
			@Override
			public FileCopier getFileCopier() {
				return new BufferedCopyProgram();
			}
		};

		public abstract FileCopier getFileCopier();
	}

	public static void main(final String[] args) throws IOException {
		if (args == null || args.length != 3) {
			System.err.println("Use: CopyProgram <source-file> <destination-file> <copying-method>");
			return;
		}

		getFileCopier(args[2]).copy(new File(args[0]), new File(args[1]));
	}

	static FileCopier getFileCopier(final String copyingMethodName) {
		final CopyingMethod copyingMethod;
		try {
			copyingMethod = CopyingMethod.valueOf(copyingMethodName.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unknown copying method: " + copyingMethodName +
					" (available methods: " + Arrays.toString(CopyingMethod.values()).toLowerCase() + ")");
		}
		return copyingMethod.getFileCopier();
	}
}
