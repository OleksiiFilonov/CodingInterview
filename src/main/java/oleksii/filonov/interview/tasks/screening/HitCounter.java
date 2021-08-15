package oleksii.filonov.interview.tasks.screening;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/design-hit-counter
 */
public class HitCounter {

    private List<Integer> hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new ArrayList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int last = Collections.binarySearch(hits, timestamp + 1);
        while(last < hits.size() - 1 && last > 0 && hits.get(last) == hits.get(last + 1)) {
            last++;
        }
        if(last < 0)
            last = - (last + 1);
        int first = Collections.binarySearch(hits, timestamp - 299);
        while(first > 0 && hits.get(first) == hits.get(first - 1)) {
            first--;
        }
        if(first < 0)
            first = - (first + 1);
        return last - first;
    }

}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

