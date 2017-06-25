package sorting.classic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * find the median element of an array using the partitioning idea of qiucksort
 */
public class QuickMedian {
    public static int median(int[] arr) {
        if (arr.length == 0) return -1;

        int l = 0;
        int h = arr.length-1;
        int med = arr.length / 2;
        int pivot = med;
        while (true) {
            pivot = partition(arr, l, h, pivot);
            if (pivot == med) {
                return arr[pivot];
            }
            if (pivot < med) {
                l = pivot;
                pivot = (h - l) / 2 + l;
            } else if (pivot > med) {
                h = pivot;
                pivot = (h - l) / 2 + l;
            }
        }
    }
    @Test
    public void medianTest() {
        assertEquals(-1, median(new int[]{}));
        assertEquals(2, median(new int[]{2}));
        assertEquals(2, median(new int[]{1,2}));
        assertEquals(2, median(new int[]{1,2,3}));
        assertEquals(2, median(new int[]{2,3,1}));
        assertEquals(3, median(new int[]{1,2,3,4,5}));
        assertEquals(3, median(new int[]{1,3,2,4,5}));
    }

    public static int partition(int[] arr, int l, int h, int p) {
        int pv = arr[p];
        swap(arr, h, p);
        int hi = l;
        for (int i = l; i < h; i++) {
            if (arr[i] < pv) {
                swap(arr, i, hi);
                hi++;
            }
        }
        swap(arr, h, hi);
        return hi;
    }
    @Test
    public void partitionTest() {
        int [] arr;
        arr = new int[]{3,2,1};
        assertEquals(1, partition(arr, 0, 2, 1));
        assertArrayEquals(new int[]{1,2,3}, arr);
        arr = new int[]{3,2,1};
        assertEquals(2, partition(arr, 0, 2, 0));
        assertArrayEquals(new int[]{1,2,3}, arr);
        arr = new int[]{3,2,1,4,0};
        assertEquals(3, partition(arr, 0, 4, 0));
        assertArrayEquals(new int[]{0,2,1,3,4}, arr);
    }

    private static void swap(int[] arr, int i, int j) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
