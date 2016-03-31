package interval_scheduling.weighted;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by amerezhi on 3/31/16.
 */
public class WeakBinarySearchTest {
    @Test
    public void smallArrayTests() {
        assertEquals(-1, WeakBinarySearch.search(new int[]{}, 0));

        assertEquals(-1, WeakBinarySearch.search(new int[]{1}, 0));
        assertEquals(0, WeakBinarySearch.search(new int[]{1}, 2));

        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3}, 1));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3}, 2));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3}, 3));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3}, 4));

        assertEquals(-1, WeakBinarySearch.search(new int[]{1, 3, 5}, 0));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3, 5}, 1));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3, 5}, 2));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3, 5}, 3));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3, 5}, 4));
        assertEquals(2, WeakBinarySearch.search(new int[]{1, 3, 5}, 5));
        assertEquals(2, WeakBinarySearch.search(new int[]{1, 3, 5}, 6));
    }

    @Test
    public void largeEvenArrayTests() {
        assertEquals(-1, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 0));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 1));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 2));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 3));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 4));
        assertEquals(2, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 5));
        assertEquals(2, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 6));
        assertEquals(3, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 7));
        assertEquals(3, WeakBinarySearch.search(new int[]{1, 3, 5, 7}, 8));
    }

    @Test
    public void largeOddArrayTests() {
        assertEquals(-1, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 0));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 1));
        assertEquals(0, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 2));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 3));
        assertEquals(1, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 4));
        assertEquals(2, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 5));
        assertEquals(2, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 6));
        assertEquals(3, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 7));
        assertEquals(3, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 8));
        assertEquals(4, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 9));
        assertEquals(4, WeakBinarySearch.search(new int[]{1, 3, 5, 7, 9}, 10));
    }

}