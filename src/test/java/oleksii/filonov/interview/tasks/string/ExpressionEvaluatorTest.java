package oleksii.filonov.interview.tasks.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionEvaluatorTest {

    @Test
    public void evaluate() {
        assertEquals(2, ExpressionEvaluator.evaluate("1+1"));
        assertEquals(7, ExpressionEvaluator.evaluate("5+3-2+1"));
        assertEquals(1, ExpressionEvaluator.evaluate("-2+3"));
        assertEquals(-5, ExpressionEvaluator.evaluate("-2-3"));
        assertEquals(-1, ExpressionEvaluator.evaluate("-2+1"));
        assertEquals(-1, ExpressionEvaluator.evaluate("1-2"));
    }
}