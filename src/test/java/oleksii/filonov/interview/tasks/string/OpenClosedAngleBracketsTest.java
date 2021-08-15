package oleksii.filonov.interview.tasks.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenClosedAngleBracketsTest {

    @Test
    void fastAppendSolution() {
        assertEquals("", OpenClosedAngleBrackets.fastAppendSolution(""));
        assertEquals("<><<><>>", OpenClosedAngleBrackets.fastAppendSolution("><<><"));
        assertEquals("<><><><>", OpenClosedAngleBrackets.fastAppendSolution(">>>>"));
        assertEquals("<<<<<>>>>>", OpenClosedAngleBrackets.fastAppendSolution("<<<<<"));
        assertEquals("<><>", OpenClosedAngleBrackets.fastAppendSolution("<>>"));
    }

    @Test
    void countingSolution() {
        assertEquals("", OpenClosedAngleBrackets.countingSolution(""));
        assertEquals("<<>>", OpenClosedAngleBrackets.countingSolution("<>>"));
        assertEquals("<><<>><>", OpenClosedAngleBrackets.countingSolution("><<><"));
        assertEquals("<<<<>>>>", OpenClosedAngleBrackets.countingSolution(">>>>"));
        assertEquals("<<<>>>", OpenClosedAngleBrackets.countingSolution(">>>"));
    }
}