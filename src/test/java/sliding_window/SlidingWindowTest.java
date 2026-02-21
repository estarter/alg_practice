package sliding_window;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SlidingWindowTest {

    // --- maxSumSubarray ---

    @Test
    void maxSumSubarray_basic() {
        assertEquals(9, SlidingWindow.maxSumSubarray(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }

    @Test
    void maxSumSubarray_allNegative() {
        assertEquals(-4, SlidingWindow.maxSumSubarray(new int[]{-2, -3, -1, -5}, 2));
    }

    @Test
    void maxSumSubarray_singleElement() {
        assertEquals(5, SlidingWindow.maxSumSubarray(new int[]{5}, 1));
    }

    @Test
    void maxSumSubarray_entireArray() {
        assertEquals(6, SlidingWindow.maxSumSubarray(new int[]{1, 2, 3}, 3));
    }

    @Test
    void maxSumSubarray_invalidK() {
        assertThrows(IllegalArgumentException.class,
                () -> SlidingWindow.maxSumSubarray(new int[]{1, 2}, 3));
    }

    // --- smallestSubarrayWithSum ---

    @Test
    void smallestSubarray_basic() {
        assertEquals(2, SlidingWindow.smallestSubarrayWithSum(new int[]{2, 1, 5, 2, 3, 2}, 7));
    }

    @Test
    void smallestSubarray_singleElement() {
        assertEquals(1, SlidingWindow.smallestSubarrayWithSum(new int[]{2, 1, 5, 2, 8}, 7));
    }

    @Test
    void smallestSubarray_entireArray() {
        assertEquals(3, SlidingWindow.smallestSubarrayWithSum(new int[]{3, 4, 1, 1, 6}, 8));
    }

    @Test
    void smallestSubarray_noResult() {
        assertEquals(0, SlidingWindow.smallestSubarrayWithSum(new int[]{1, 2, 3}, 10));
    }

    @Test
    void smallestSubarray_emptyArray() {
        assertEquals(0, SlidingWindow.smallestSubarrayWithSum(new int[]{}, 5));
    }

    // --- longestSubstringWithoutRepeating ---

    @Test
    void longestSubstring_basic() {
        assertEquals(3, SlidingWindow.longestSubstringWithoutRepeating("abcabcbb"));
    }

    @Test
    void longestSubstring_allSame() {
        assertEquals(1, SlidingWindow.longestSubstringWithoutRepeating("bbbbb"));
    }

    @Test
    void longestSubstring_mixed() {
        assertEquals(3, SlidingWindow.longestSubstringWithoutRepeating("pwwkew"));
    }

    @Test
    void longestSubstring_empty() {
        assertEquals(0, SlidingWindow.longestSubstringWithoutRepeating(""));
    }

    @Test
    void longestSubstring_allUnique() {
        assertEquals(5, SlidingWindow.longestSubstringWithoutRepeating("abcde"));
    }

    @Test
    void longestSubstring_singleChar() {
        assertEquals(1, SlidingWindow.longestSubstringWithoutRepeating("a"));
    }

    // --- twoSumSorted ---

    @Test
    void twoSum_basic() {
        assertArrayEquals(new int[]{1, 2},
                SlidingWindow.twoSumSorted(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    void twoSum_middleElements() {
        assertArrayEquals(new int[]{1, 5},
                SlidingWindow.twoSumSorted(new int[]{1, 3, 4, 5, 7, 10}, 8));
    }

    @Test
    void twoSum_negativeNumbers() {
        assertArrayEquals(new int[]{1, 3},
                SlidingWindow.twoSumSorted(new int[]{-3, 0, 3, 5}, 0));
    }

    @Test
    void twoSum_noSolution() {
        assertThrows(IllegalArgumentException.class,
                () -> SlidingWindow.twoSumSorted(new int[]{1, 2, 3}, 10));
    }
}
