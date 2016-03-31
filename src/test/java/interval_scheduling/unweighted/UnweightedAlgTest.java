package interval_scheduling.unweighted;

import interval_scheduling.Interval;
import java.util.List;
import org.junit.Test;

/**
 * Created by amerezhi on 3/31/16.
 */
public class UnweightedAlgTest {

    @Test
    public void testExample() throws Exception {
        Interval[] intervals = new Interval[]{
                new Interval("Summer school", 0, 2),
                new Interval("Semester 1", 3, 6),
                new Interval("Trimester 1", 3, 5),
                new Interval("Trimester 2", 5, 7),
                new Interval("Semester 2", 8, 11),
                new Interval("Trimester 3", 9, 10)
        };

        List<Interval> bestIntervals = UnweightedAlg.scheduleIntervals(intervals);
        bestIntervals.forEach(System.out::println);


    }
}