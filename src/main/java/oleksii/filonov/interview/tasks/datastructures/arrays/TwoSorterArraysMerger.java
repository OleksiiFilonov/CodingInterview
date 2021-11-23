package oleksii.filonov.interview.tasks.datastructures.arrays;

/*
    Merge sorter array b into a bigger size sorted array a.
    array a has exactly enough empty elements at the end to accomodate array b
    Example
    a = [1, 5, 6, >9, None, None, >None ]
    b = [3, 4, >7]
    Result should be
    a = [1, 3, 4, 5, 6, 7, 9]
 */
public class TwoSorterArraysMerger {

    public static int[] merge(int [] a, int [] b) {
        int iA = a.length - b.length -1, iB = b.length -1, insertTo = a.length-1;
        while(insertTo >=0 && iB >= 0) {
            if(iA >= 0 && a[iA] > b[iB]) {
                a[insertTo] = a[iA];
                iA--;
            } else {
                a[insertTo] = b[iB];
                iB--;
            }
            insertTo--;
        }
        return a;
    }
}
