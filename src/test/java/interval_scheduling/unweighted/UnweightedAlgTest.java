package interval_scheduling.unweighted;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import interval_scheduling.Interval;

/**
 * Created by amerezhi on 3/31/16.
 */
class UnweightedAlgTest {

    @Test
    void testExample() {
        Interval[] intervals = new Interval[]{
                new Interval("Summer school", 0, 2),
                new Interval("Semester 1", 3, 6),
                new Interval("Trimester 1", 3, 5),
                new Interval("Trimester 2", 5, 7),
                new Interval("Semester 2", 8, 11),
                new Interval("Trimester 3", 9, 10)
        };

        List<Interval> bestIntervals = UnweightedAlg.scheduleIntervals(intervals);
        Interval[] expected = new Interval[]{intervals[0], intervals[1], intervals[3], intervals[4]};
        assertArrayEquals(expected, bestIntervals.toArray(new Interval[]{}));
    }
}