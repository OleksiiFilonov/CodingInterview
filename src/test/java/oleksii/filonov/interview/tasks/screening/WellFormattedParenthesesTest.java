package oleksii.filonov.interview.tasks.screening;


import org.junit.jupiter.api.Test;

import static oleksii.filonov.interview.tasks.screening.WellFormattedParentheses.check;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WellFormattedParenthesesTest {

    @Test
    public void checkForWellFormatted() {
        assertTrue(check("()"));
        assertFalse(check("[)"));
        assertFalse(check("()("));
        assertFalse(check("(("));
        assertFalse(check("(()"));
        assertFalse(check("(([)])"));
        assertTrue(check("(()[])"));
        assertTrue(check("{(()[])}"));
    }
}