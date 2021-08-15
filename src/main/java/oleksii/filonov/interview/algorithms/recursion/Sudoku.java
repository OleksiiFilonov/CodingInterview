package oleksii.filonov.interview.algorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sudoku {

    static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        if (isSolved(board, 0, 0))
            return board;
        else
            throw new RuntimeException("Solution is not possible");
    }

    private static int N = 9;

    private static boolean isSolved(List<ArrayList<Integer>> board, int row, int col) {
        //System.out.println("Row: " + row + ", Column: " + col);
        if (row == N) {
            return true;
        } else if (board.get(row).get(col) > 0) {
            int[] nextCell = findNextCell(board, row, col);
            return isSolved(board, nextCell[0], nextCell[1]);
        }
        Set<Integer> candidates = findCandidates(board, row, col);
        for (Integer candidate : candidates) {
            board.get(row).set(col, candidate);
            int[] nextCell = findNextCell(board, row, col);
            if (!isSolved(board, nextCell[0], nextCell[1])) {
                board.get(row).set(col, 0);
            } else {
                return true;
            }
        }
        return false;
    }

    private static int[] findNextCell(List<ArrayList<Integer>> board, int row, int col) {
        if (col == N - 1) {
            return new int[]{row + 1, 0};
        } else {
            return new int[]{row, col + 1};
        }
    }

    private static Set<Integer> findCandidates(List<ArrayList<Integer>> board, int row, int col) {
        Set<Integer> candidates = new HashSet<>(IntStream.range(1, 10).mapToObj(value -> Integer.valueOf(value)).collect(Collectors.toSet()));
        if (checkRow(candidates, board, row).size() > 0
                && checkColumn(candidates, board, col).size() > 0
                && checkSquare(candidates, board, row, col).size() > 0) {
            return candidates;
        } else {
            return Collections.emptySet();
        }
    }

    private static Set<Integer> checkSquare(Set<Integer> candidates, List<ArrayList<Integer>> board, int row, int col) {
        int sRow = (row / 3) * 3;
        int sCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                candidates.remove(board.get(sRow + i).get(sCol + j));
            }
        }
        return candidates;
    }

    private static Set<Integer> checkRow(Set<Integer> candidates, List<ArrayList<Integer>> board, int row) {
        for (int col = 0; col < N; col++) {
            candidates.remove(board.get(row).get(col));
        }
        return candidates;
    }

    private static Set<Integer> checkColumn(Set<Integer> candidates, List<ArrayList<Integer>> board, int col) {
        for (int row = 0; row < N; row++) {
            candidates.remove(board.get(row).get(col));
        }
        return candidates;
    }


}
