package oleksii.filonov.interview.algorithms;

import java.util.Scanner;


/**
 * Task from https://www.hackerrank.com/challenges/java-1d-array/problem
 * Let's play a game on an array! You're standing at index of an -element array named . From some index (where ), you can perform one of the following moves:

    Move Backward: If cell exists and contains a , you can walk back to cell .
    Move Forward:
        If cell contains a zero, you can walk to cell .
        If cell contains a zero, you can jump to cell .
        If you're standing in cell or the value of , you can walk or jump off the end of the array and win the game.

In other words, you can move from index to index , , or as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.

Given and , complete the function in the editor below so that it returns true if you can win the game (or false if you cannot).
 */
public class HopsIn1DArray {
	
    public static boolean canWin(int leap, int[] game) {
        return isSolvable(leap, game, 0);
    }
    
    private static boolean isSolvable(int leap, int [] game, int index) {
        if (index < 0 || game[index] == 1) return false;
        if (index + leap >= game.length || index == game.length - 1) return true;
        game[index] = 1;
        return isSolvable(leap, game, index-1) || isSolvable(leap, game, index + 1) || isSolvable(leap, game, index + leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}