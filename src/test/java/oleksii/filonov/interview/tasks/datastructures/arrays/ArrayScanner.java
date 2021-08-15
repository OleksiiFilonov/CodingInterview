package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

public final class ArrayScanner {

	private static int[] readArrayOver(String inputFile) {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan;
		try {
			scan = new Scanner(Paths.get(resourceDir.getPath(), inputFile).toFile());
			int rows = scan.nextInt();
			int[] elements = new int[rows];
			for (int i = 0; i < rows; i++) {
				elements[i] = scan.nextInt();
			}
			scan.close();
			return elements;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private static Long [] readLongArrayOver(String inputFile) {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan;
		try {
			scan = new Scanner(Paths.get(resourceDir.getPath(), inputFile).toFile());
			int rows = scan.nextInt();
			Long [] elements = new Long [rows];
			for (int i = 0; i < rows; i++) {
				elements[i] = scan.nextLong();
			}
			scan.close();
			return elements;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static int[] readArray(String inputFile) {
		return readArrayOver(inputFile);
	}

	public static Long [] readLongArray(String inputFile) {
		return readLongArrayOver(inputFile);
	}
	
	/**
	 * builds array int [rows][columns] from file. Number of rows - first integer in the file
	 * @param columns - number of columns in 2D array
	 * @param inputFile - name of the file
	 * @return int [rows][columns]
	 */
	public static int[][] read2DArray(int columns, String inputFile) {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan;
		try {
			scan = new Scanner(Paths.get(resourceDir.getPath(), inputFile).toFile());
			int rows = scan.nextInt();
			int[][] elements = new int[rows][columns];
			for (int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++)
					elements[i][j] = scan.nextInt();
			}
			scan.close();
			return elements;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
