package oleksii.filonov.interview.contests.google.kickstart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000436140/000000000068cb14
 * For maximum Heap use negative number, so max values would be first
 * use long instead of int to calculate sum
 */
public class RabbitHouse {

    private static final class Cell {
        private int boxes;
        private int r;
        private int c;

        private Cell(int boxes, int r, int c) {
            this.boxes = boxes;
            this.r = r;
            this.c = c;
        }
    }

    private static int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
            int r = in.nextInt(); //rows
            int c = in.nextInt(); //columns
            int[][] matrix = new int[r][c];
            Queue<Cell> q = new PriorityQueue<>(Comparator.comparingInt(cell -> -cell.boxes));
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = in.nextInt();
                    if(matrix[i][j] > 1)
                        q.add(new Cell(matrix[i][j], i, j));
                }
            }
            long boxes = 0;
            while (!q.isEmpty()) {
                Cell max = q.poll();
                for (int[] direction : directions) {
                    int x = max.r + direction[0];
                    int y = max.c + direction[1];
                    if (x >= 0 && y >= 0 && x < matrix.length
                            && y < matrix[0].length
                            && max.boxes -  matrix[x][y] > 1) {
                        boxes += max.boxes - matrix[x][y] - 1;
                        matrix[x][y] = max.boxes - 1;
                        q.add(new Cell(matrix[x][y], x, y));
                    }
                }
            }
            System.out.println("Case #" + caseIndex + ": " + boxes);
        }
    }
}