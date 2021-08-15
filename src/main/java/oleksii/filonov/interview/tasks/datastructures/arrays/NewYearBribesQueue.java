package oleksii.filonov.interview.tasks.datastructures.arrays;

/**
 * From https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class NewYearBribesQueue {
	
	/**
	 * @param q - queue of people.
	 * @return -1 if queue is Too Chaotic or number of bribes
	 */
    public static int minimumBribes(int[] q) {
        int bribes = 0;
        for(int i=0; i < q.length; i++) {
            int diff = q[i] - i - 1;
            if(diff > 2) {
                System.out.println("Too chaotic");
                return -1;
            }
            for(int j = Math.max(0, q[i] - 2); j < i; j++) {
            	if(q[j] > q[i]) bribes++;
            }
        }
        System.out.println(bribes);
        return bribes;
    }

}
