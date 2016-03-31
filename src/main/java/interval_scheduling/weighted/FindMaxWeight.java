package interval_scheduling.weighted;

import interval_scheduling.Interval;

import java.util.Arrays;

/**
 * Find max weight using DP
 * @see http://www.cs.cornell.edu/courses/cs482/2007sp/dynamic.pdf
 * @see https://github.com/farazdagi/algorithms/blob/master/weighted-interval-scheduling.py
 */
public class FindMaxWeight {
    public static int findMaxWeight(Interval[] intervals) {
        if (intervals.length == 0) return 0;

        // O(n*logN)
        Arrays.sort(intervals, (o1, o2) -> o1.finish - o2.finish);

        // 2*N + O(n*logN) => O(n*logN)
        int[] prevIntervalIndex = getPrevIntervals(intervals);

        int[] maxPrices = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int additionalPrice = prevIntervalIndex[i] < 0 ? 0 : maxPrices[prevIntervalIndex[i]];
            maxPrices[i] = Math.max(intervals[i].price + additionalPrice, i == 0 ? 0 : maxPrices[i-1]);
        }

        return maxPrices[intervals.length-1];
    }

    static int[] getPrevIntervals(Interval[] intervals) {
        int[] finish = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            finish[i] = intervals[i].finish;
        }

        int[] prevIntervals = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            prevIntervals[i] = WeakBinarySearch.search(finish, intervals[i].start);
        }
        return prevIntervals;
    }

}
