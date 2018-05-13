package heap;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.function.IntUnaryOperator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Heap {

    private final int[] data;
    private int size;

    public Heap(int cap) {
        data = new int[cap];
        size = 0;
    }

    public void push(int val) {
        if (size >= data.length - 1) {
            throw new IndexOutOfBoundsException("Heap is full.");
        }
        data[size++] = val;
        siftUp();
    }

    private void siftUp() {
        int idx = size - 1;
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (data[parent] > data[idx]) {
                swap(parent, idx);
                idx = parent;
            } else {
                return;
            }
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Can't peek on empty heap.");
        }
        return data[0];
    }

    public int pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Can't pop on empty heap.");
        }
        int result = data[0];
        data[0] = data[size - 1];
        size--;
        siftDown();
        return result;
    }

    private void siftDown() {
        IntUnaryOperator getVal = (index) -> index < size ? data[index] : Integer.MAX_VALUE;

        int idx = 0;
        while (((idx + 1) * 2 - 1) < size) {
            int pl = (idx + 1) * 2 - 1;
            int pr = (idx + 1) * 2;
            if (getVal.applyAsInt(idx) > Math.min(getVal.applyAsInt(pl), getVal.applyAsInt(pr))) {
                int swapIdx = getVal.applyAsInt(pl) < getVal.applyAsInt(pr) ? pl : pr;
                swap(idx, swapIdx);
                idx = swapIdx;
            } else {
                return;
            }
        }
    }

    private void swap(int i1, int i2) {
        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }

    public int size() {
        return size;
    }
}

class HeapTest {

    @Test
    void test() {
        Heap heap = new Heap(10);
        heap.push(1);
        Assertions.assertEquals(1, heap.peek());
        Assertions.assertEquals(1, heap.pop());
        heap.push(2);
        heap.push(3);
        Assertions.assertEquals(2, heap.peek());
        Assertions.assertEquals(2, heap.pop());
        Assertions.assertEquals(3, heap.peek());
        heap.push(1);
        Assertions.assertEquals(1, heap.peek());
    }

    @Test
    void test2() {
        Heap heap = new Heap(10);
        heap.push(10);
        heap.push(1);
        heap.push(9);
        heap.push(2);
        heap.push(8);
        Assertions.assertEquals(1, heap.pop());
        Assertions.assertEquals(2, heap.pop());
        Assertions.assertEquals(8, heap.pop());
        heap.push(2);
        heap.push(1);
        Assertions.assertEquals(1, heap.pop());
        Assertions.assertEquals(2, heap.pop());
        Assertions.assertEquals(9, heap.pop());
        Assertions.assertEquals(10, heap.pop());
    }

    @Test
    void test_priority_queue() {
        final int amount = 100_000;
        Heap heap = new Heap(amount);
        PriorityQueue<Integer> refHeap = new PriorityQueue<>();
        Random random = new Random();
        int maxSize = 0;
        for (int i = 0; i < amount; i++) {
            maxSize = Math.max(maxSize, heap.size());
            if (random.nextInt(10) < 7 || heap.size() == 0) {
                int val = random.nextInt();
                heap.push(val);
                refHeap.add(val);
            } else {
                Assertions.assertEquals((int) refHeap.poll(), heap.pop());
            }
        }
        System.out.println("maxSize = " + maxSize);
    }
}
