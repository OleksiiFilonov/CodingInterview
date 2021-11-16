package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
# == == == == == == == == == == == == == == == == == == == == == =
#
# Given a matrix of M x N elements (M rows, N columns),
# return all elements of the matrix in diagonal order as shown in the examples.
#
# Example:
#
# Input: 3x3
# [[1, 2, 3],
#  [4, 5, 6],
#  [7, 8, 9]]

# Output: 5 x 3
# [
#  [1],           (0, 0) = 0
#  [2, 4],        (0, 1) (1, 0) = 1
#  [3, 5, 7],     (0, 2) (1, 1) (2, 0) = 2
#  [6, 8],        (1, 2) (2, 1) = 3
#  [9]            (2, 2) = 4
# ]
#
# Input: 4 x 5
# [[12, 7, 21, 31, 11],
#  [45, -2, 14, 27, 19],
#  [-3, 15, 36, 71, 26],
#  [4, -13, 55, 34, 15]]

output rows = columns + rows - 1;
output rows = columns +
# Output: 8 x 4
# [
#  [12],
#  [7, 45],
#  [21, -2, -3],
#  [31, 14, 15, 4],
#  [11, 27, 36, -13],
#  [19, 71, 55],
#  [26, 34],
#  [15]
# ]
#
# Input: []
# Output: []
# == == == == == == == == == == == == == == == == == == == == == =
*/
public class DiagonalArrayPrinter {

    public static int[][] printIteratively(int[][] array) {
        int colLen = array[0].length;
        int rowLen = array.length;
        int[][] result = new int[colLen + rowLen - 1][];
        int outputRowIndex = 0;
        //iterate over 1 row
        for (int col = 0; col < colLen; col++, outputRowIndex++) {
            result[outputRowIndex] = printDiagonal(array, 0, col);
        }
        for (int row = 1; row < rowLen; row++, outputRowIndex++) {
            result[outputRowIndex] = printDiagonal(array, row, colLen - 1);
        }
        return result;
    }

    private static int[] printDiagonal(int[][] array, int row, int col) {
        int[] result = new int[Math.min(array.length - row, col + 1)];
        int current = 0;
        while (row < array.length && col >= 0) {
            result[current++] = array[row][col];
            row++;
            col--;
        }
        return result;
    }

    public static int[][] printBFS(int[][] array) {
        int colLen = array[0].length;
        int rowLen = array.length;
        int[][] result = new int[colLen + rowLen - 1][];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{0, 0});
        int outputRowIndex = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            result[outputRowIndex] = new int[size];
            for (int i = 0; i < size - 1; i++) {
                int[] node = bfs.poll();
                result[outputRowIndex][i] = array[node[0]][node[1]];
                //right node
                int newCol = node[1] + 1;
                if (newCol < colLen)
                    bfs.add(new int[]{node[0], newCol});
            }
            //pull last node for the row and add right and bottom node if possible
            int[] node = bfs.poll();
            result[outputRowIndex][size - 1] = array[node[0]][node[1]];
            //right node
            int newCol = node[1] + 1;
            if (newCol < colLen)
                bfs.add(new int[]{node[0], newCol});
            //bottom node
            int newRow = node[0] + 1;
            if (newRow < rowLen)
                bfs.add(new int[]{newRow, node[1]});
            outputRowIndex++;
        }
        return result;
    }
}
