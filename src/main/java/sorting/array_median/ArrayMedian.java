package sorting.array_median;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class ArrayMedian {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int pos = (a.size() + b.size()) / 2 + 1;
        if ((a.size() + b.size()) % 2 == 0) {
            return (double) (findKth(a, 0, b, 0, pos) + findKth(a, 0, b, 0, pos-1)) / 2.0;
        } else {
            return findKth(a, 0, b, 0, pos);
        }
    }

    public int findKth(List<Integer> a, int idxA, List<Integer> b, int idxB, int pos) {
        if (idxA >= a.size()) return b.get(idxB + pos - 1);
        if (idxB >= b.size()) return a.get(idxA + pos - 1);
        if (pos == 1) return Math.min(a.get(idxA), b.get(idxB));

        int a_key = idxA + pos / 2 - 1 < a.size() ? a.get(idxA + pos / 2 - 1) : Integer.MAX_VALUE;
        int b_key = idxB + pos / 2 - 1 < b.size() ? b.get(idxB + pos / 2 - 1) : Integer.MAX_VALUE;
        if (a_key < b_key) return findKth(a, idxA + pos / 2, b, idxB, pos - pos / 2);
        else               return findKth(a, idxA, b, idxB + pos / 2, pos - pos / 2);
        // int a_key = idxA < a.size() ? a.get(idxA) : Integer.MAX_VALUE;
        // int b_key = idxB < b.size() ? b.get(idxB) : Integer.MAX_VALUE;
        // if (a_key < b_key) return findKth(a, idxA + 1, b, idxB, pos - 1);
        // else               return findKth(a, idxA, b, idxB + 1, pos - 1);
    }

    @Test
    public void test_findKth() {
        assertEquals(0, findKth(Arrays.asList(0, 10, 15, 20, 25), 0, Arrays.asList(), 0, 1));
        assertEquals(10, findKth(Arrays.asList(0, 10, 15, 20, 25), 0, Arrays.asList(), 0, 2));
        assertEquals(15, findKth(Arrays.asList(0, 10, 15, 20, 25), 0, Arrays.asList(), 0, 3));
        assertEquals(0, findKth(Arrays.asList(0, 20, 25), 0, Arrays.asList(10, 15), 0, 1));
        assertEquals(10, findKth(Arrays.asList(0, 20, 25), 0, Arrays.asList(10, 15), 0, 2));
        assertEquals(15, findKth(Arrays.asList(0, 20, 25), 0, Arrays.asList(10, 15), 0, 3));

        assertEquals(2, findKth(Arrays.asList(1, 2), 0, Arrays.asList(3, 4), 0, 2));
        assertEquals(3, findKth(Arrays.asList(1, 2), 0, Arrays.asList(3, 4), 0, 3));
    }

    @Test
    public void test1() {
        assertEquals(15,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(0, 10, 15, 20, 25)), new ArrayList<>(Arrays.asList())),
                0.1);
        assertEquals(10,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(0, 10, 15)), new ArrayList<>(Arrays.asList())),
                0.1);
        assertEquals(1,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList())),
                0.1);

        assertEquals(1,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(0, 2)), new ArrayList<>(Arrays.asList())),
                0.1);
        assertEquals(1,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(0)), new ArrayList<>(Arrays.asList(2))),
                0.1);
        assertEquals(1,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(0, 1)), new ArrayList<>(Arrays.asList(2))),
                0.1);
        assertEquals(2,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(3))),
                0.1);
        assertEquals(2.5,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(3, 4))),
                0.1);
        assertEquals(3,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 2, 5)), new ArrayList<>(Arrays.asList(3, 4))),
                0.1);
        assertEquals(5,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(5)), new ArrayList<>(Arrays.asList())),
                0.1);
        assertEquals(11.5,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 22)), new ArrayList<>(Arrays.asList(0, 23))),
                0.1);
        assertEquals(11.5,
                findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 22)), new ArrayList<>(Arrays.asList())),
                0.1);
    }

    @Test
    public void test2() {
        assertEquals(-20.0,
                findMedianSortedArrays(
                        new ArrayList<>(Arrays.asList(-50, -41, -40, -19, 5, 21, 28)),
                        new ArrayList<>(Arrays.asList(-50, -21, -10))),
                0.1);
    }
}
