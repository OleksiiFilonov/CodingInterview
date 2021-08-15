package oleksii.filonov.interview.tasks.screening;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


public class WellFormattedParenthesesGeneratorTest {

    private WellFormattedParenthesesGenerator testInstance = new WellFormattedParenthesesGenerator();
    private static final Set<String> EXPECTED = Set.of("((()))", "(()())", "(())()", "()(())", "()()()");

    @Test
    public void generateParenthesisAllCases() {
        Set<String> actual = new HashSet<>(testInstance.generateParenthesisAllCases(3));
        Assertions.assertEquals(EXPECTED.size(), actual.size());
        Assertions.assertTrue(actual.containsAll(EXPECTED));
    }

    @Test
    public void generateParenthesis() {
        Set<String> actual = new HashSet<>(testInstance.generateParenthesis(3));
        Assertions.assertEquals(EXPECTED.size(), actual.size());
        Assertions.assertTrue(actual.containsAll(EXPECTED));
    }
}