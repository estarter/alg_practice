package interval_scheduling.weighted;

import interval_scheduling.Interval;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amerezhi on 3/31/16.
 */
public class FindMaxWeightTest {
    @Test
    public void testSimple() throws Exception {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 10"),
                new Interval("3 7 14"),
                new Interval("5 9 7"),
                new Interval("6 9 8")
        };
        assertEquals(18, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    public void testAnotherExample() throws Exception {
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
    public void testExample3() throws Exception {
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
    public void testEmtpy() throws Exception {
        Interval[] Intervals  = new Interval[]{
        };
        assertEquals(0, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    public void testOne() throws Exception {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 10")
        };
        assertEquals(10, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    public void testSameLength() throws Exception {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 11"),
                new Interval("0 5 10")
        };
        assertEquals(11, FindMaxWeight.findMaxWeight(Intervals));
    }
    @Test
    public void testShortIsBetter() throws Exception {
        Interval[] Intervals  = new Interval[]{
                new Interval("0 5 10"),
                new Interval("2 5 11")
        };
        assertEquals(11, FindMaxWeight.findMaxWeight(Intervals));
    }
}