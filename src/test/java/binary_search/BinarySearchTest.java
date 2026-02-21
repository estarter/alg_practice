package binary_search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    // classic binary search tests

    @Test
    void searchFindsElement() {
        assertEquals(2, BinarySearch.search(new int[]{1, 3, 5, 7, 9}, 5));
    }

    @Test
    void searchFindsFirstElement() {
        assertEquals(0, BinarySearch.search(new int[]{1, 3, 5, 7, 9}, 1));
    }

    @Test
    void searchFindsLastElement() {
        assertEquals(4, BinarySearch.search(new int[]{1, 3, 5, 7, 9}, 9));
    }

    @Test
    void searchReturnsMinusOneWhenNotFound() {
        assertEquals(-1, BinarySearch.search(new int[]{1, 3, 5, 7, 9}, 4));
    }

    @Test
    void searchEmptyArray() {
        assertEquals(-1, BinarySearch.search(new int[]{}, 1));
    }

    @Test
    void searchSingleElement() {
        assertEquals(0, BinarySearch.search(new int[]{5}, 5));
        assertEquals(-1, BinarySearch.search(new int[]{5}, 3));
    }

    // rotated array search tests

    @Test
    void searchRotatedFindsInLeftHalf() {
        assertEquals(1, BinarySearch.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
    }

    @Test
    void searchRotatedFindsInRightHalf() {
        assertEquals(4, BinarySearch.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    void searchRotatedNotFound() {
        assertEquals(-1, BinarySearch.searchRotated(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    void searchRotatedNoRotation() {
        assertEquals(2, BinarySearch.searchRotated(new int[]{1, 2, 3, 4, 5}, 3));
    }

    @Test
    void searchRotatedSingleElement() {
        assertEquals(0, BinarySearch.searchRotated(new int[]{1}, 1));
        assertEquals(-1, BinarySearch.searchRotated(new int[]{1}, 0));
    }

    @Test
    void searchRotatedTwoElements() {
        assertEquals(0, BinarySearch.searchRotated(new int[]{2, 1}, 2));
        assertEquals(1, BinarySearch.searchRotated(new int[]{2, 1}, 1));
    }

    // find peak element tests

    @Test
    void findPeakSingleElement() {
        assertEquals(0, BinarySearch.findPeakElement(new int[]{1}));
    }

    @Test
    void findPeakAtEnd() {
        int peak = BinarySearch.findPeakElement(new int[]{1, 2, 3});
        assertEquals(2, peak);
    }

    @Test
    void findPeakAtStart() {
        int peak = BinarySearch.findPeakElement(new int[]{3, 2, 1});
        assertEquals(0, peak);
    }

    @Test
    void findPeakInMiddle() {
        int peak = BinarySearch.findPeakElement(new int[]{1, 3, 2});
        assertEquals(1, peak);
    }

    @Test
    void findPeakMultiplePeaks() {
        int[] arr = {1, 3, 2, 4, 1};
        int peak = BinarySearch.findPeakElement(arr);
        // any peak is valid
        assertTrue(peak == 1 || peak == 3);
    }
}
