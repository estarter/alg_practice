package sorting.classic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Alexey Merezhin
 */
public class SelectionSort {

    char[] sort(char[] arr, boolean animate) {
        if (animate) {
            System.out.println("|" + new String(arr));
        }
        for (int i = arr.length; i > 1; i--) {
            int pos = arr.length - i;
            int min = pos;
            for (int j = min+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            char tmp = arr[pos];
            arr[pos] = arr[min];
            arr[min] = tmp;

            if (animate) {
                char[] xx = new char[arr.length+1];
                System.arraycopy(arr, 0, xx, 0, pos+1);
                System.arraycopy(arr, pos, xx, pos+1, arr.length - pos);
                xx[pos+1] = '|';
                System.out.println(xx);
            }
        }
        if (animate) {
            System.out.println(new String(arr) + "|");
        }
        return arr;
    }

    @Test
    public void test() {
        char[] res = sort("selectionsort".toCharArray(), true);
        char[] exp = "selectionsort".toCharArray();
        Arrays.sort(exp);
        assertArrayEquals(exp, res);
    }

}
