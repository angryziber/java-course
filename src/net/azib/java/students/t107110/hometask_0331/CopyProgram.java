package net.azib.java.students.t107110.hometask_0331;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;

/**
 * @author Eduard Shustrov
 */
public class CopyProgram {
	private enum CopyingMethod {
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
			System.out.println("Use: CopyProgram <source-file> <destination-file> <copying-method>");
			return;
		}

		final CopyingMethod copyingMethod;
		try {
			copyingMethod = CopyingMethod.valueOf(args[2].toUpperCase());
		} catch (IllegalArgumentException e) {
			System.out.println("Unknown copying method: " + args[2]);
			System.out.println("Available copying methods:");
			for (CopyingMethod availableCopyingMethod : CopyingMethod.values())
				System.out.println(availableCopyingMethod.toString().toLowerCase());
			return;
		}
		copyingMethod.getFileCopier().copy(new File(args[0]), new File(args[1]));
	}
}
