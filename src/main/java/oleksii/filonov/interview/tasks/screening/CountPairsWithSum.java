package oleksii.filonov.interview.tasks.screening;

import java.util.*;

public class CountPairsWithSum {

    public static void main(String[] args) {
        System.out.println(countPairsWithSum(8, new int[] {2, 3, 6, 2, 8}));
    }

    private static int countPairsWithSum(int k, int[] a) {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            values.add(a[i]);
        }
        Set<Integer> pairsSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            int difference = k - a[i];
            if (values.contains(difference) && !pairsSet.contains(a[i]) && !pairsSet.contains(difference)) {
                pairsSet.add(a[i]);
            }
        }
        return pairsSet.size();
    }


    private static int productMinusSum(int n) {
        return product(n) - sum(n);
    }

    private static int product(int n) {
        if (n == 0) return 1;
        return (n % 10) * product(n / 10);
    }

    private static int sum(int n) {
        if (n == 0) return 0;
        return (n % 10) + sum(n / 10);
    }
}
