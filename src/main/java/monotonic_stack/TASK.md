# Monotonic Stack

## What is a Monotonic Stack?

A monotonic stack is a stack that maintains its elements in either strictly increasing or strictly decreasing order. When pushing a new element, elements that violate the monotonic property are popped first. This pattern is useful for efficiently finding the next greater/smaller element for each position in an array.

### Use cases
- Next greater/smaller element problems
- Sliding window maximum/minimum
- Largest rectangle in histogram
- Stock span problems
- Trapping rain water

## Problems

### Next Greater Element

Given an array of integers, for each element find the next element that is strictly greater than the current element. If no such element exists, return -1.

**Example:** `[4, 2, 6, 1, 3]` -> `[6, 6, -1, 3, -1]`

**Approach:** Traverse the array from right to left, maintaining a decreasing monotonic stack. For each element, pop all smaller or equal elements from the stack. The top of the stack (if any) is the next greater element.

- Time complexity: O(N) - each element is pushed and popped at most once
- Space complexity: O(N) - for the stack and result array

### Sliding Window Maximum

Given an array of integers and a window size k, find the maximum element in each sliding window of size k.

**Example:** `[1, 3, -1, -3, 5, 3, 6, 7]`, k=3 -> `[3, 3, 5, 5, 6, 7]`

**Approach:** Use a monotonic deque (double-ended queue) that stores indices. Maintain elements in decreasing order. For each new element, remove smaller elements from the back. Remove elements outside the window from the front. The front of the deque is always the maximum.

- Time complexity: O(N) - each element is added and removed from the deque at most once
- Space complexity: O(k) - the deque holds at most k elements
