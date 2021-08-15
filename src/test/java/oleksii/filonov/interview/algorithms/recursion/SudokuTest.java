package oleksii.filonov.interview.algorithms.recursion;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuTest {

    public static final double SUDOKU_SIZE = 9;

    @Test
    public void solvePuzzle() throws IOException {
        File resourceDir = Paths.get("src", "test", "resources").toFile();
        BufferedReader reader = new BufferedReader(new FileReader(
                Paths.get(resourceDir.getPath(), "Sudoku.txt").toFile()));
        ArrayList<ArrayList<Integer>> input = readBoard(reader);
        ArrayList<ArrayList<Integer>> expected = readBoard(reader);
        ArrayList<ArrayList<Integer>> result = Sudoku.solve_sudoku_puzzle(input);
        for (int row = 0; row < SUDOKU_SIZE; row++) {
            for (int col = 0; col < SUDOKU_SIZE; col++) {
                Integer expectedValue = expected.get(row).get(col);
                Integer actualValue = result.get(row).get(col);
                assertEquals(expectedValue, actualValue,
                        String.format("Expected value %s doesn't match with actual %s in [%s, %s]", expectedValue, actualValue, row, col));
            }
        }
    }

    private ArrayList<ArrayList<Integer>> readBoard(BufferedReader reader) throws IOException {
        //skip Input Line
        reader.readLine();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            parseRow(reader, input);
        }
        return input;
    }

    private void parseRow(BufferedReader reader, ArrayList<ArrayList<Integer>> input) throws IOException {
        ArrayList<Integer> row = new ArrayList<>();
        //parse [8, 4, 9, 0, 0, 3, 5, 7, 0]
        String line = reader.readLine();
        for (String num : line.substring(1, line.length() - 1).split(", "))
            row.add(Integer.valueOf(num));
        input.add(row);
    }
}