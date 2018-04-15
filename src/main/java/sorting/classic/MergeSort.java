package sorting.classic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexey Merezhin
 */
public class MergeSort {
    public static int[] sort(int[] arr) {
        if (arr.length < 2) return arr;
        return sort(arr, 0, arr.length-1);
    }

    private static int[] sort(int[] arr, int from, int to) {
        if (to - from < 1) return arr;
        int m = (to - from) / 2 + from;
        sort(arr, from, m);
        sort(arr, m+1, to);
        return merge(arr, from, m, to);
    }

    private static int[] merge(int[] arr, int from, int m, int to) {
        int[] tmp = Arrays.copyOfRange(arr, from, to+1);
        int i = from;
        int i1 = from, i2 = m+1;
        while (i1 <= m && i2 <= to) {
            if (tmp[i1 - from] > tmp[i2 - from]) {
                arr[i] = tmp[i2 - from];
                i2++;
            } else {
                arr[i] = tmp[i1 - from];
                i1++;
            }
            i++;
        }
        while (i1 <= m) {
            arr[i] = tmp[i1 - from];
            i1++;
            i++;
        }
        while (i2 <= to) {
            arr[i] = tmp[i2 - from];
            i2++;
            i++;
        }
        return arr;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,2,3}, sort(new int[]{2,1,3}));
        assertArrayEquals(new int[]{1,2,3}, sort(new int[]{3,2,1}));
        assertArrayEquals(new int[]{1,2,3}, sort(new int[]{1,2,3}));
        assertArrayEquals(new int[]{1,2,3,4}, sort(new int[]{4,3,2,1}));
        assertArrayEquals(new int[]{1,2,3,4}, sort(new int[]{4,2,3,1}));
        assertArrayEquals(new int[]{1,2,3,4,5}, sort(new int[]{4,2,3,1,5}));
    }
}
