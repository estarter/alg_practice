package sorting.min_el_stack;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class MinElStack {
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();
    public void push(int el) {
        stack.push(el);
        if(minStack.isEmpty()|| el<minStack.peek() )
            minStack.push(el);
    }
    public int pop() {
        int res = stack.pop();
        if (res == minEl()) {
            minStack.pop();
        }
        return res;
    }
    public int minEl() {
        return minStack.peek();
    }

    @Test
    public void test() {
        MinElStack stack = new MinElStack();
        stack.push(1);
        assertEquals(1, stack.minEl());
        assertEquals(1, stack.pop());

        stack.push(2);
        assertEquals(2, stack.minEl());
        stack.push(1);
        assertEquals(1, stack.minEl());
        stack.push(3);
        assertEquals(1, stack.minEl());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.minEl());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.minEl());
    }
}
