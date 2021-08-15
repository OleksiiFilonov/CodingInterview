package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.util.Arrays;

/**
 * https://www.facebook.com/careers/life/sample_interview_questions
 */
public class Spiral2DArray {
	
	public static int[][] greedilyTraverse(int n) {
		int[][] matrix = new int [n][n];
		int limit = n*n;
		/**
		 * 0 - right
		 * 1 - down
		 * 2 - left
		 * 3 - top
		 */
		int direction = 0;
		int counter = 0;
		int i = 0, j=0;
		int [] incrementRow = new int [] {0, 1, 0, -1};
		int [] incrementColumn = new int [] {1, 0, -1, 0};
		//right, down, left, top
		while(counter < limit) {
			counter++;
			matrix[i][j] = counter;
			i += incrementRow[direction];
			j += incrementColumn[direction];
			if(!canContinue(matrix, i, j)) {
				i -= incrementRow[direction];
				j -= incrementColumn[direction];
				direction = (direction+1) % 4;
				i += incrementRow[direction];
				j += incrementColumn[direction];
			};
	
		}
		return matrix;
	}

	private static boolean canContinue(int[][] matrix, int i, int j) {
		return (i >= 0) && (j >= 0) && (i < matrix.length) && (j < matrix.length) && (matrix[i][j] == 0);
	}
	
	private static void print(int [][] array) {
		for (int[] subarray : array) {
			System.out.println(Arrays.toString(subarray));
		}
	}
	
	public static int[][] recursionTraverse(int n) {
		return recursionFiller(new int [n][n], 1, 0, n);
	}

	private static int[][] recursionFiller(int[][] matrix, int counter, int begin, int end) {
		if(begin == end ) return matrix;
		if(end - begin == 1) {
			matrix[begin][begin] = counter;
			return matrix;
		}
		int i=begin, j=begin;
		//fill top from left to right
		for(; j < end; j++)
			matrix[i][j] = counter++;
		j--; counter--;
		//fill right edge from top to down
		for(; i < end; i++)
			matrix[i][j] = counter++;
		i--; counter--;
		//fill bottom from right to left
		for(; j >= begin; j--)
			matrix[i][j] = counter++;
		j++; counter--;
		//fill left edge from bottom to top
		for(; i > begin; i--)
			matrix[i][j] = counter++;
		return recursionFiller(matrix, counter, begin+1, end-1);
	}
	public static void main(String[] args) {
		print(greedilyTraverse(3));
		print(greedilyTraverse(4));
		print(recursionTraverse(3));
		print(recursionTraverse(4));
	}

}
