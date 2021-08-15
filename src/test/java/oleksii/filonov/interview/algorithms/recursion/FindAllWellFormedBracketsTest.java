package oleksii.filonov.interview.algorithms.recursion;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllWellFormedBracketsTest {

    private FindAllWellFormedBrackets brackets = new FindAllWellFormedBrackets();

    @Test
    public void find0() {
        assertEquals(0, brackets.find(0).length);
    }

    @Test
    public void find1() {
        assertArrayEquals(new String[]{"()"}, brackets.find(1));
    }

    @Test
    public void find3() {
        assertArrayEquals(new String[]{
                        "((()))",
                        "(()())",
                        "(())()",
                        "()(())",
                        "()()()"},
                brackets.find(3));
    }
}