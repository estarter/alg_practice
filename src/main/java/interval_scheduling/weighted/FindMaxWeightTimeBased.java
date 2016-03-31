package interval_scheduling.weighted;

import interval_scheduling.Interval;

/**
 * Created by amerezhi on 3/31/16.
 */
public class FindMaxWeightTimeBased {
    public static int findMaxWeight(Interval[] intervals) {
        int maxTime = getMaxTime(intervals);
        int[] maxWeights = new int[maxTime+1];
        maxWeights[0] = 0;
        for (int i = 1; i < maxWeights.length; i++) {
            int maxPrice = 0;
            for (int j = 0; j < i; j++) {
                maxPrice = Math.max(maxPrice, maxWeights[j] + getBestForTimeInterval(intervals, j, i));
            }
            maxWeights[i] = maxPrice;
        }
        return maxWeights[maxTime];
    }

    private static int getBestForTimeInterval(Interval[] intervals, int from, int to) {
        int maxWeight = 0;
        for (Interval Interval : intervals) {
            if (Interval.isInInterval(from, to)) {
                maxWeight = Math.max(maxWeight, Interval.price);
            }
        }
        return maxWeight;
    }

    private static int getMaxTime(Interval[] intervals) {
        int max = 0;
        for (Interval Interval : intervals) {
            max = Math.max(max, Interval.start + Interval.duration);
        }
        return max;
    }

}
