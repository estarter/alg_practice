package kth_smallest_element;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class KthSmallestElement {

    static int minK(int k, int[] data) {
        partSort(data, k, 0, data.length - 1);
        return data[k - 1];
    }

    static void partSort(int[] data, int k, int from, int to) {
        if (from > k) {
            return;
        }
        if (to <= from) {
            return;
        }
        if (to - from == 1) {
            if (data[from] > data[to]) {
                swap(data, from, to);
            }
            return;
        }
        // int pivotIdx = (to + from) / 2;
        // randomly selected pivot index improve performance to O(n), worth case - O(n^2)
        int pivotIdx = new Random().nextInt(to - from + 1) + from;
        int pivot = data[pivotIdx];
        swap(data, pivotIdx, to);
        int li = from;
        for (int hi = from; hi < to; hi++) {
            if (data[hi] <= pivot) {
                swap(data, li, hi);
                li++;
            }
        }
        swap(data, li, to);
        partSort(data, k, from, li - 1);
        partSort(data, k, li + 1, to);
    }

    static void swap(int[] data, int i, int j) {
        if (i == j)
            return;
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}

class KTest {

    @Test
    void test1() {
        assertEquals(3, KthSmallestElement.minK(1, new int[] { 7, 10, 4, 3, 20, 15 }));
        assertEquals(4, KthSmallestElement.minK(2, new int[] { 7, 10, 4, 3, 20, 15 }));
        assertEquals(7, KthSmallestElement.minK(3, new int[] { 7, 10, 4, 3, 20, 15 }));
        assertEquals(10, KthSmallestElement.minK(4, new int[] { 7, 10, 4, 3, 20, 15 }));
        assertEquals(15, KthSmallestElement.minK(5, new int[] { 7, 10, 4, 3, 20, 15 }));
        assertEquals(20, KthSmallestElement.minK(6, new int[] { 7, 10, 4, 3, 20, 15 }));
    }

    @Test
    void test2() {
        assertEquals(4, KthSmallestElement.minK(1, new int[] { 7, 10, 4, 20, 15 }));
        assertEquals(7, KthSmallestElement.minK(2, new int[] { 7, 10, 4, 20, 15 }));
        assertEquals(10, KthSmallestElement.minK(3, new int[] { 7, 10, 4, 20, 15 }));
        assertEquals(15, KthSmallestElement.minK(4, new int[] { 7, 10, 4, 20, 15 }));
        assertEquals(20, KthSmallestElement.minK(5, new int[] { 7, 10, 4, 20, 15 }));
    }
}