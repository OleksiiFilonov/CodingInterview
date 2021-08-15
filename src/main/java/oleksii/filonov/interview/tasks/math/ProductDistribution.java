package oleksii.filonov.interview.tasks.math;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class ProductDistribution {

    public static int maxScore(List<Integer> a, int m) {
        Collections.sort(a);
        int numberOfSegments = a.size() / m;
        BigInteger sum = BigInteger.ZERO;
        int i = 1;
        long productsSum = 0;
        for (; i < numberOfSegments; i++) {

            for (int j = (i-1)*m; j < i*m; j++)
                productsSum += a.get(j);
            sum = sum.add(BigInteger.valueOf(i*productsSum));
            productsSum = 0;
        }
        for (int j = (i-1)*m; j < a.size(); j++)
            productsSum += a.get(j);
        sum = sum.add(BigInteger.valueOf(i*productsSum));

        return sum.remainder(BigInteger.valueOf(1000000007)).intValueExact();
    }
}
