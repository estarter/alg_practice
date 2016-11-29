package max_repetition;

/**
 * @author Alexey Merezhin
 */
public class MaxRepetition {
    public static int getMaxRepetition(int[] a) {
        int max = Integer.MIN_VALUE;
        int idx = -1;

        for (int i = 0; i < a.length; i++) {
            int ii = a[i] % a.length;
            a[ii] += a.length;
            if (max < a[ii]) {
                max = a[ii];
                idx = ii;
            }
        }
        return idx;
    }
}
