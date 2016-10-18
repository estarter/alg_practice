package dynamic_programming;

/**
 * @author Alexey Merezhin
 */
class ZigZag {
    int longestZigZag(int[] seq) {
        if (seq.length < 2) return seq.length;

        int[] pos = new int[seq.length];
        int[] neg = new int[seq.length];
        pos[0] = 1;
        neg[0] = 1;

        for (int i = 1; i < seq.length; i++) {
            pos[i] = 1;
            neg[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    pos[i] = Math.max(pos[i], neg[j] + 1);
                } else if (seq[i] < seq[j]) {
                    neg[i] = Math.max(neg[i], pos[j] + 1);
                }
            }
        }

        return Math.max(pos[seq.length - 1], neg[seq.length - 1]);
    }

    int longestZigZag_v1(int[] seq) {
        if (seq.length < 2) return seq.length;

        int total = 1;
        int current = seq[0];
        int prevDiff = 0;
        for (int i = 1; i < seq.length; i++) {
            int diff = current - seq[i];
            if ((diff > 0 && prevDiff <= 0) ||
                    (diff < 0 && prevDiff >= 0)) {
                total++;
                current = seq[i];
                prevDiff = diff;
            } else {
                if (prevDiff > 0) {
                    current = Math.min(current, seq[i]);
                } else {
                    current = Math.max(current, seq[i]);
                }
            }
        }
        return total;
    }
}

