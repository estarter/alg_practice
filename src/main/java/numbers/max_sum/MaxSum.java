package numbers.max_sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * find a subset of numbers with max sum
 *
 * @author Alexey Merezhin
 */
public class MaxSum {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int from = 0;
        int len = 0;
        long sum = 0;
        int maxFrom = 0;
        int maxLen = 0;
        long maxSum = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < 0) {
                if (maxSum < sum || (maxSum == sum && maxLen < len)) {
                    maxFrom = from;
                    maxSum = sum;
                    maxLen = len;
                }
                from = i + 1;
                sum = 0;
                len = 0;
            } else {
                sum += a.get(i);
                len++;
            }
        }
        if (maxSum < sum || (maxSum == sum && maxLen < len)) {
            maxFrom = from;
            maxLen = len;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = maxFrom; i < maxFrom + maxLen; i++) {
            result.add(a.get(i));
        }
        return result;
    }

    @Test
    public void test() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[]{336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421}));
        assertTrue(maxset(a).equals(new ArrayList<>(Arrays.asList(new Integer[]{1101513929, 1315634022}))));

        a = new ArrayList<>(Arrays.asList(new Integer[]{756898537, -1973594324, -2038664370, -184803526, 1424268980}));
        assertTrue(maxset(a).toString(), maxset(a).equals(new ArrayList<>(Arrays.asList(new Integer[]{1424268980}))));
    }

}
