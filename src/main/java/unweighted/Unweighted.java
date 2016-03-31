package unweighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amerezhi on 3/30/16.
 */
public class Unweighted {

    public static List<Interval> scheduleUnweightedIntervals(Interval[] intervals) {
        Arrays.sort(intervals);

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

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval("Summer school", 0, 2),
                new Interval("Semester 1", 3, 6),
                new Interval("Trimester 1", 3, 5),
                new Interval("Trimester 2", 5, 7),
                new Interval("Semester 2", 8, 11),
                new Interval("Trimester 3", 9, 10)
        };

        List<Interval> bestIntervals = scheduleUnweightedIntervals(intervals);
        bestIntervals.forEach(System.out::println);
    }
}


class Interval implements Comparable {
    String name;
    int start;
    int finish;
    public Interval(String name, int start, int finish) {
        this.name = name;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Object o) {
        return finish - ((Interval) o).finish;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}