package interval_scheduling.unweighted;

import interval_scheduling.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amerezhi on 3/31/16.
 */
public class UnweightedAlg {

    public static List<Interval> scheduleIntervals(Interval[] intervals) {
        // sort intervals by finish time - O(N*log(N))
        Arrays.sort(intervals, (i1, i2) -> i1.finish - i2.finish);

        // select the intervals that fits the best - O(N)
        List<Interval> result = new ArrayList<>();
        int finish = 0;
        for (Interval interval : intervals) {
            if (finish <= interval.start) {
                finish = interval.finish;
                result.add(interval);
            }
        }
        return result;
    }

}
