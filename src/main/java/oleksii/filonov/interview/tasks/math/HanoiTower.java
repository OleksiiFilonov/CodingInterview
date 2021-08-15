package oleksii.filonov.interview.tasks.math;

import java.util.Scanner;

public class HanoiTower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        move(n, 'A', 'B', 'C');
    }

    private static void move(int n, char from, char to, char spare) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + from + " to " + to);
        } else {
            move(n - 1, from, spare, to);
            System.out.println("Move disk " + n + " from " + from + " to " + to);
            move(n - 1, spare, to, from);
        }
    }
}
