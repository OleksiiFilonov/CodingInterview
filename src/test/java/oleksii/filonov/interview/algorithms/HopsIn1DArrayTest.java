package oleksii.filonov.interview.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class HopsIn1DArrayTest {

	@Test
	public void testInput04() throws IOException {
		File resourceDir = Paths.get("src", "test", "resources").toFile();
		Scanner scan = new Scanner(Paths.get(resourceDir.getPath(), "HopsIn1DArrayTestInput04.txt").toFile());
		int inputNumbers = scan.nextInt();
		final int size = inputNumbers;
		BufferedReader br = new BufferedReader(new FileReader(Paths.get(resourceDir.getPath(), "HopsIn1DArrayTestAnswers04.txt").toFile()));
		while (inputNumbers-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}
			String answerLine = br.readLine();
			assertEquals("Test failed at the input in the descending order: " + (size - inputNumbers)*2 + "for array: "
					+ Arrays.toString(game), answerLine, (HopsIn1DArray.canWin(leap, game)) ? "YES" : "NO");
		}
		br.close();
		scan.close();
	}

}
