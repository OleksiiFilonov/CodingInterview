package oleksii.filonov.interview.tasks.screening;

import oleksii.filonov.interview.tasks.screening.HitCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HitCounterTest {

    @Test
    public void testHits() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        assertEquals(3, hitCounter.getHits(4));
        assertEquals(3, hitCounter.getHits(300));
        hitCounter.hit(300);
        assertEquals(4, hitCounter.getHits(300));
        assertEquals(3, hitCounter.getHits(301));
    }

    @Test
    public void testDuplicateHits() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(300);
        assertEquals(4, hitCounter.getHits(300));
    }

    @Test
    public void test() {
        System.out.println("yodn".compareTo("ewqz"));
    }

}