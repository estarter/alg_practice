package sorting.classic;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Alexey Merezhin
 */
public class HeapSort {
    public int[] sort(int[] arr) {
        heapify(arr);
        heapSort(arr);
        return arr;
    }

    /**
     * sort heap-array
     */
    private int[] heapSort(int[] heap) {
        for (int i = heap.length-1; i > 0; i--) {
            swap(heap, 0, i);
            bubbleDown(heap, 0, i-1);
        }
        return heap;
    }
    private void bubbleDown(int[] arr, int idx, int n) {
        int child = (idx + 1) * 2 - 1;
        int minIdx = idx;
        for (int i = 0; i < 2; i++) {
            int childIdx = child + i;
            if (childIdx <= n && cmp(arr[minIdx], arr[childIdx])) {
                minIdx = childIdx;
            }
        }
        if (minIdx != idx) {
            swap(arr, minIdx, idx);
            bubbleDown(arr, minIdx, n);
        }
    }

    /**
     * convert arr into a heap
     */
    private int[] heapify(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            bubbleUp(arr, i);
        }
        return arr;
    }
    private void bubbleUp(int[] arr, int idx) {
        if (idx == 0) return; /* root elem */
        int parent = (idx + 1) / 2 - 1;
        if (cmp(arr[parent], arr[idx])) {
            swap(arr, parent, idx);
            bubbleUp(arr, parent);
        }
    }

    boolean cmp(int a, int b) {
        return a < b;
    }

    private void swap(int[] arr, int i, int j) {
        int val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(heapify(new int[]{2,1,3})));
        System.out.println(Arrays.toString(heapify(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(heapify(new int[]{7,6,1,2,3,4,5})));
        assertArrayEquals(sort(new int[]{}), new int[]{});
        assertArrayEquals(sort(new int[]{1}), new int[]{1});
        assertArrayEquals(sort(new int[]{2,1}), new int[]{1,2});
        assertArrayEquals(sort(new int[]{2,1,3}), new int[]{1,2,3});
        assertArrayEquals(sort(new int[]{2,1,3,4}), new int[]{1,2,3,4});
        assertArrayEquals(sort(new int[]{2,5,1,3,4}), new int[]{1,2,3,4,5});
    }

    /**
     * return true if {x} is in first {count} biggest elements
     */
    public boolean isInFirstK(int[] heap, int count, int x) {
        return heapCompare(heap, 0, count, x) > 0;
    }
    private int heapCompare(int[] heap, int i, int count, int x) {
        if (count <= 0 || i >= heap.length) return count;

        if (heap[i] > x) {
            count = count - 1;
            int child = (i + 1) * 2 - 1;
            count = heapCompare(heap, child, count, x);
            count = heapCompare(heap, child+1, count, x);
        }

        return count;
    }

    @Test
    public void testHeapCompare() {
        int[] heap = heapify(new int[]{7,6,1,2,3,4,5}); // [7, 6, 5, 2, 3, 1, 4]
        assertFalse(isInFirstK(heap, 0, 7));
        assertTrue(isInFirstK(heap, 1, 7));
        assertTrue(isInFirstK(heap, 8, 7));

        assertFalse(isInFirstK(heap, 1, 6));
        assertTrue(isInFirstK(heap, 2, 6));

        assertFalse(isInFirstK(heap, 2, 5));
        assertTrue(isInFirstK(heap, 3, 5));

        assertFalse(isInFirstK(heap, 3, 4));
        assertTrue(isInFirstK(heap, 4, 4));

        assertFalse(isInFirstK(heap, 4, 3));
        assertTrue(isInFirstK(heap, 5, 3));

        assertFalse(isInFirstK(heap, 5, 2));
        assertTrue(isInFirstK(heap, 6, 2));
    }

}
