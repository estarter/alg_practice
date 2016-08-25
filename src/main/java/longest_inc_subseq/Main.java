package longest_inc_subseq;

import java.util.*;

/**
 * @author Alexey Merezhin
 */
public class Main {
    public Integer[] findLongestIncSubseq(Integer[] seq) {
        int[] maxLengths = new int[seq.length];
        int totalMax = 0;
        for (int i = 0; i < seq.length; i++) {
            int max = -1;
            for (int j = 0; j <= i; j++) {
                if (seq[i] > seq[j]) {
                    max = Math.max(maxLengths[j], max);
                }
            }
            maxLengths[i] = max+1;
            totalMax = Math.max(maxLengths[i], totalMax);
        }

        int curMax = totalMax;
        Deque<Integer> result = new ArrayDeque<>();
        for (int i = seq.length-1; i >= 0; i--) {
            if (curMax == maxLengths[i]) {
                curMax--;
                result.addFirst(seq[i]);
            }
        }
        return result.toArray(new Integer[0]);
    }
}
