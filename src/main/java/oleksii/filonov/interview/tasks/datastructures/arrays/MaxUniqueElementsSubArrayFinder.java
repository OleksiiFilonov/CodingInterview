package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.util.*;

public class MaxUniqueElementsSubArrayFinder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = in.nextInt();
        }
        in.close();
        System.out.println(findMaximumUniqueSubArray(m, elements));
    }

    public static int findMaximumUniqueSubArray(int m, int[] elements) {
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < elements.length && max < m; i++) {
            int num = elements[i];
            map.merge(num, 1, Integer::sum);
            deque.addLast(num);
            if (i >= m) {
                Integer first = deque.removeFirst();
                Integer firstOccurrence = map.get(first);
                if (firstOccurrence > 1) {
                    map.put(first, firstOccurrence - 1);
                } else {
                    map.remove(first);
                }
            }
            if (max < map.size()) {
                max = map.size();
            }
        }
        return max;
    }


}
