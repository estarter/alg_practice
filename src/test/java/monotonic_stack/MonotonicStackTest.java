package monotonic_stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonotonicStackTest {

    // --- nextGreaterElement tests ---

    @Test
    void nextGreaterElement_basic() {
        assertThat(MonotonicStack.nextGreaterElement(new int[]{4, 2, 6, 1, 3}))
                .isEqualTo(new int[]{6, 6, -1, 3, -1});
    }

    @Test
    void nextGreaterElement_descending() {
        assertThat(MonotonicStack.nextGreaterElement(new int[]{5, 4, 3, 2, 1}))
                .isEqualTo(new int[]{-1, -1, -1, -1, -1});
    }

    @Test
    void nextGreaterElement_ascending() {
        assertThat(MonotonicStack.nextGreaterElement(new int[]{1, 2, 3, 4, 5}))
                .isEqualTo(new int[]{2, 3, 4, 5, -1});
    }

    @Test
    void nextGreaterElement_singleElement() {
        assertThat(MonotonicStack.nextGreaterElement(new int[]{42}))
                .isEqualTo(new int[]{-1});
    }

    @Test
    void nextGreaterElement_duplicates() {
        assertThat(MonotonicStack.nextGreaterElement(new int[]{2, 2, 2}))
                .isEqualTo(new int[]{-1, -1, -1});
    }

    @Test
    void nextGreaterElement_empty() {
        assertThat(MonotonicStack.nextGreaterElement(new int[]{}))
                .isEqualTo(new int[]{});
    }

    // --- slidingWindowMaximum tests ---

    @Test
    void slidingWindowMaximum_basic() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))
                .isEqualTo(new int[]{3, 3, 5, 5, 6, 7});
    }

    @Test
    void slidingWindowMaximum_windowSizeOne() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{4, 2, 7, 1}, 1))
                .isEqualTo(new int[]{4, 2, 7, 1});
    }

    @Test
    void slidingWindowMaximum_windowSizeEqualsArray() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{3, 1, 4, 1, 5}, 5))
                .isEqualTo(new int[]{5});
    }

    @Test
    void slidingWindowMaximum_descending() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{5, 4, 3, 2, 1}, 3))
                .isEqualTo(new int[]{5, 4, 3});
    }

    @Test
    void slidingWindowMaximum_ascending() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{1, 2, 3, 4, 5}, 3))
                .isEqualTo(new int[]{3, 4, 5});
    }

    @Test
    void slidingWindowMaximum_allSame() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{7, 7, 7, 7}, 2))
                .isEqualTo(new int[]{7, 7, 7});
    }

    @Test
    void slidingWindowMaximum_empty() {
        assertThat(MonotonicStack.slidingWindowMaximum(new int[]{}, 3))
                .isEqualTo(new int[]{});
    }
}
