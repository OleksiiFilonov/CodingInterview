package oleksii.filonov.interview.algorithms.dynamicprogramming;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RopeCuttingWithMaxProductTest {

    RopeCuttingWithMaxProduct target = new RopeCuttingWithMaxProduct();

    @Test
    public void recursion() {
        assertEquals(9, target.recursion(6));
        assertEquals(54, target.recursion(11));
        assertEquals(8748, target.recursion(25));
    }

    @Test
    public void dp() {
        assertEquals(9, target.dp(6));
        assertEquals(54, target.dp(11));
        assertEquals(8748, target.dp(25));
        assertEquals(150094635296999121L, target.dp(108));
    }

}