package interval_scheduling.weighted;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import interval_scheduling.Interval;

/**
 * Created by amerezhi on 3/31/16.
 */
class FindMaxWeightTest {
    @Test
    void testSimple() {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 10"),
                new Interval("3 7 14"),
                new Interval("5 9 7"),
                new Interval("6 9 8")
        };
        assertEquals(18, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    void testAnotherExample() {
        Interval[] Intervals = new Interval[] {
                new Interval("0 5 6"),
                new Interval("2 3 1"),
                new Interval("8 5 11"),
                new Interval("15 2 1"),
                new Interval("15 5 10"),
                new Interval("1 4 3"),
                new Interval("20 1 1"),
                new Interval("20 2 10"),
                new Interval("25 2 15"),
                new Interval("25 2 11")
        };
        assertEquals(52, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    void testExample3() {
        Interval[] Intervals = new Interval[] {
                new Interval("0 5 6"),
                new Interval("2 3 1"),
                new Interval("8 5 11"),
                new Interval("15 2 1"),
                new Interval("15 5 10"),
                new Interval("1 4 3"),
                new Interval("20 1 1"),
                new Interval("20 2 10"),
                new Interval("25 2 15"),
                new Interval("25 2 11")
        };
        assertEquals(52, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    void testEmpty() {
        Interval[] Intervals  = new Interval[]{
        };
        assertEquals(0, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    void testOne() {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 10")
        };
        assertEquals(10, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    void testSameLength() {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 11"),
                new Interval("0 5 10")
        };
        assertEquals(11, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    void testShortIsBetter() {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 10"),
                new Interval("2 5 11")
        };
        assertEquals(11, FindMaxWeight.findMaxWeight(Intervals));
    }
}