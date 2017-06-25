package sorting.classic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * sort an array so that all negative elements precede all positive elements
 */
public class QuickZeroSplit {

    int[] sort(int[] arr) {
        int ni = 0; // negative elements index
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                swap(arr, i, ni);
                ni++;
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int ni) {
        int tmp = arr[i];
        arr[i] = arr[ni];
        arr[ni] = tmp;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{-1, -2, 0, 1, 2}, sort(new int[]{1, 2, 0, -1, -2}));
        assertArrayEquals(new int[]{-2, -1, 0, 1, 2}, sort(new int[]{1, -2, 0, -1, 2}));
    }
}
