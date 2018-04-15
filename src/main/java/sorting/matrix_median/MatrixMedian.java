package sorting.matrix_median;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.
 *
 * @author Alexey Merezhin
 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int l = 0;
        int r = 0;
        for (List<Integer> arr : A) {
            r = Math.max(r, arr.get(arr.size()-1));
        }
        int req = A.size() * A.get(0).size() / 2 + 1;

        while (r - l > 1) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (List<Integer> arr : A) {
                count += amountOfElementsLessOrEqualTo(arr, mid);
            }

            if (count >= req) r = mid;
            else l = mid;
        }
        return r;
    }

    private int amountOfElementsLessOrEqualTo(List<Integer> arr, int value) {
        int low = 0;
        int high = arr.size()-1;
        while (high >= low) {
            int m = (high - low) / 2 + low;
            if (arr.get(m) > value) {
                high = m-1;
            } else {
                low = m+1;
            }
        }
        if (high == -1) return 0;
        if (arr.get(high) == value) return high + 1;
        else if (arr.get(high) < value) return high + 1;
        else return high - 1;
    }

    @Test
    public void test_amountOfElementsLessOrEqualTo() {
        assertEquals(0, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 0));
        assertEquals(1, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 1));
        assertEquals(1, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 2));
        assertEquals(3, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 3));
        assertEquals(3, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 4));
        assertEquals(4, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 5));
        assertEquals(4, amountOfElementsLessOrEqualTo(Arrays.asList(1, 3, 3, 5), 6));
    }

    @Test public void test1() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        input.add(new ArrayList<>(Arrays.asList(2, 6, 9)));
        input.add(new ArrayList<>(Arrays.asList(3, 6, 9)));
        assertEquals(5, findMedian(input));

        input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3)));
        assertEquals(2, findMedian(input));
    }

    @Test public void test2() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(2, 3, 8)));
        input.add(new ArrayList<>(Arrays.asList(4, 8, 10)));
        input.add(new ArrayList<>(Arrays.asList(4, 7, 9)));
        input.add(new ArrayList<>(Arrays.asList(2, 8, 10)));
        input.add(new ArrayList<>(Arrays.asList(1, 2, 8)));
        input.add(new ArrayList<>(Arrays.asList(4, 4, 4)));
        input.add(new ArrayList<>(Arrays.asList(3, 8, 9)));
        assertEquals(4, findMedian(input));
    }

    @Test public void test2_same() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 7, 8, 8, 8, 8, 8, 9, 9, 10, 10)));
        assertEquals(4, findMedian(input));
    }

    @Test public void test3() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(1, 2, 11)));
        assertEquals(2, findMedian(input));
    }

    @Test public void test4() {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(9, 10, 10, 13, 14, 15, 16, 16, 16, 17, 18)));
        input.add(new ArrayList<>(Arrays.asList(1, 4, 9, 14, 16, 18, 19, 22, 26, 26, 27)));
        input.add(new ArrayList<>(Arrays.asList(4, 6, 7, 10, 14, 20, 21, 23, 24, 27, 28)));
        assertEquals(16, findMedian(input));
    }

}
