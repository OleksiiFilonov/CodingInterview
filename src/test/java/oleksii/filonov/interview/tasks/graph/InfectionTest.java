package oleksii.filonov.interview.tasks.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfectionTest {

    private Infection infection = new Infection();

    /**
     * Wall example
     * Input:
     * [[2, 1],
     * [0, 2]]
     * Output: -1
     */
    @Test
    public void humansSurvive() {
        int[][] input = new int[][]{{2, 1}, {0, 2}};
        assertEquals(-1, infection.countDaysToInfect(input));
    }

    /**
     * Input:
     * [[1, 0, 0, 0, 1],
     *  [0, 0, 0, 0, 0]]
     * Output: 3
     */
    @Test
    public void infectAllIn3Days() {
        int[][] input = new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}};
        assertEquals(3, infection.countDaysToInfect(input));
    }

}