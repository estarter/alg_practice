package sorting.classic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

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

}
