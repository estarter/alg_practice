package max_cont_subseq;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
public class MaxContiuousSubseq {
    public static int[] maxContSequence(int[] arr) {
        if (arr.length == 0) return new int[]{0, 0, -1};
        int[] res = new int[]{Integer.MIN_VALUE, 0, 0};
        int[] tmp = new int[]{0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (tmp[0] + arr[i] > arr[i]) {
                tmp[0] += arr[i];
            } else {
                tmp[0] = arr[i];
                tmp[1] = i;
            }
            tmp[2] = i;

            if (tmp[0] > res[0]) {
                System.arraycopy(tmp, 0, res, 0, 3);
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 2, 2}, MaxContiuousSubseq.maxContSequence(new int[]{1,-2,3}));
        assertArrayEquals(new int[]{12,2,4}, MaxContiuousSubseq.maxContSequence(new int[]{-1,-2,3,4,5}));
        assertArrayEquals(new int[]{9,0,4}, MaxContiuousSubseq.maxContSequence(new int[]{1,2,3,-2,5}));
    }
}
