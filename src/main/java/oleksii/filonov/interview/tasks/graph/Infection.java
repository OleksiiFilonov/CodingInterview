package oleksii.filonov.interview.tasks.graph;

/*
Given a 2D grid, each cell contains a human 0, zombie 1, or wall 2 (numbers 0, 1, 2).
Zombies can turn adjacent (up/down/left/right) human beings into zombies every day, but cannot go through walls.
How long will it take to turn all people into zombies? Return -1 if not all humans are turned into zombies.

Main example
Input:
[[1, 0, 0, 0, 1],
 [0, 0, 0, 0, 0]]
Output: 3

Explanation:
At the end of the 1st day, the status of the grid:
[[1, 1, 0, 1, 1],
 [1, 0, 0, 0, 1]]

At the end of the 2nd day, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 0, 1, 1]]

Wall example
Input:
[[2, 1],
 [0, 2]]
Output: -1
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Infection {

    private final int [][] directions = new int [][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public int countDaysToInfect(int [][] input) {
        int days = 0;
        Queue<int []> zombies = new LinkedList<>();
        int humans = 0;
        for (int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                if(input[i][j] == 0) {
                    humans++;
                } else if(input[i][j] == 1) {
                    zombies.add(new int [] {i, j});
                }
            }
        }
        while(!zombies.isEmpty() && humans > 0) {
            days++;
            int size = zombies.size();
            for (int s = 0; s < size; s++) {
                int[] zombie = zombies.poll();
                System.out.printf("days=%s, humans=%s, zombie=%s%n", days, humans, Arrays.toString(zombie));
                for (int[] direction : directions) {
                    int i = zombie[0] + direction[0];
                    int j = zombie[1] + direction[1];
                    if (i >= 0 && i < input.length && j >= 0 && j < input[0].length && input[i][j] == 0) {
                        input[i][j] = 1;
                        humans--;
                        zombies.add(new int[]{i, j});
                    }
                }
            }
        }

        return (humans > 0) ? -1: days;
    }
}
