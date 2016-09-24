package longest_inc_subseq;

import java.util.*;

/**
 * @author Alexey Merezhin
 */
public class Main {

    // O(N*logN)
    public static List<Integer> longest_increasing_subsequence(List<Integer> seq) {
        List<int[]> min = new ArrayList<int[]>(seq.size());
        min.add(new int[]{seq.get(0), 0});
        List<Integer> prev = new ArrayList<Integer>(seq.size());
        prev.add(-1);
        for (int i = 1; i < seq.size(); i++) {
            int val = seq.get(i);

            int idx = getPos(min, val);

            if (idx == min.size()) {
                min.add(new int[]{val, i});
            } else {
                if (val < min.get(idx)[0]) {
                    min.get(idx)[0] = val;
                    min.get(idx)[1] = i;
                }
            }
            if (idx == 0) {
                prev.add(-1);
            } else {
                prev.add(min.get(idx-1)[1]);
            }

        }

        List<Integer> result = new ArrayList<Integer>();
        int idx = min.get(min.size()-1)[1];
        while (idx >= 0) {
            result.add(seq.get(idx));
            idx = prev.get(idx);
        }

        Collections.reverse(result);
        return result;
    }

    static int getPos(List<int[]> min, int value) {
        int lo = 0;
        int hi = min.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (value == min.get(mid)[0]) {
                return mid;
            }
            if (value > min.get(hi)[0]) return hi + 1;
            if (value < min.get(lo)[0]) return lo;

            if (value > min.get(mid)[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        throw new RuntimeException("failed to pos an element");
    }

    // O(N^2)
    public static Integer[] findLongestIncSubseq(Integer[] seq) {
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
