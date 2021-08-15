package oleksii.filonov.interview.algorithms.dynamicprogramming;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaysToDecodeTest {

    private WaysToDecode target = new WaysToDecode();

    @Test
    public void recursion() {
        assertEquals(2, target.numDecodings("11106"));
        assertEquals(2, target.numDecodings("12"));
        assertEquals(3, target.numDecodings("226"));
        assertEquals(0, target.numDecodings("0"));
        assertEquals(0, target.numDecodings("06"));
        assertEquals(6765, target.numDecodings("1111111111111111111"));
    }

    @Test
    public void dynamicProgramming() {
        assertEquals(2, target.dp("11106"));
        assertEquals(2, target.dp("12"));
        assertEquals(3, target.dp("226"));
        assertEquals(0, target.dp("0"));
        assertEquals(0, target.dp("06"));
        assertEquals(6765, target.dp("1111111111111111111"));
    }
}