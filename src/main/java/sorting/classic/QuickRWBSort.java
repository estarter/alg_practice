package sorting.classic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * sort arr of r/w/b elements so that first comes all r then all w then all b
 */
public class QuickRWBSort {

    char[] sort(char[] arr) {
        if (arr.length == 0) return arr;
        int ri = 0;
        while (arr[ri] == 'r') ri++;
        int bi = arr.length-1;
        while (arr[bi] == 'b') bi--;

        for (int i = ri; i <= bi; i++) {
            if (arr[i] == 'b') {
                swap(arr, bi, i);
                bi--;
            }
            if (arr[i] == 'r') {
                swap(arr, ri, i);
                ri++;
            }
        }
        return arr;
    }

    @Test
    public void test() {
        assertArrayEquals(new char[]{'r', 'w', 'b'}, sort(new char[]{'r', 'w', 'b'}));
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, sort(new char[]{'r', 'w', 'b', 'w', 'r', 'b'}));
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, sort(new char[]{'w', 'b', 'r', 'w', 'b', 'r'}));
        assertArrayEquals(new char[]{'r', 'r', 'w', 'w', 'b', 'b'}, sort(new char[]{'w', 'w', 'r', 'b', 'b', 'r'}));
    }

    private static void swap(char[] arr, int i, int j) {
        char x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
