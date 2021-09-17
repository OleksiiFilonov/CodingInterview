package oleksii.filonov.interview.tasks.screening;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinimumAverageValueTest {

    private MinimumAverageValueSplitter splitter = new MinimumAverageValueSplitter();

    @Test
    public void split() {
        int[][] result = splitter.split(new int[]{1, 2, 3, 4, 5, 6});
        assertArrayEquals(new int[]{1, 2, 5, 6}, result[0], () -> Arrays.toString(result[0]));
        assertArrayEquals(new int[]{3, 4}, result[1], () -> Arrays.toString(result[1]));
    }
}