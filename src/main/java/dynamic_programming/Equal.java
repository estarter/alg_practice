package dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues. She is biased
 * towards her friends and may have distributed the chocolates unequally. One of the program managers gets to know this
 * and orders Christy to make sure everyone gets equal number of chocolates.
 *
 * But to make things difficult for the intern, she is ordered to equalize the number of chocolates for every colleague
 * in the following manner,
 *
 * For every operation, she can choose one of her colleagues and can do one of the three things.
 *
 * She can give one chocolate to every colleague other than chosen one.
 * She can give two chocolates to every colleague other than chosen one.
 * She can give five chocolates to every colleague other than chosen one.
 * Calculate minimum number of such operations needed to ensure that every colleague has the same number of chocolates.
 */
public class Equal {
    private static int solve(int[] input) {
        if (input.length == 0) throw new IllegalArgumentException("Input array can't be empty");

        Arrays.sort(input);
        int[] result = new int[5];
        for (int j = 0; j < result.length; j++) {
            int res = 0;
            for (int i = 0; i < input.length; i++) {
                int diff = input[i] - input[0] + j;
                res += diff / 5 + (diff % 5) / 2 + (diff % 5) % 2;
            }
            result[j] = res;
        }
        return Arrays.stream(result).min().getAsInt();
    }
    @Test
    public void test() {
        assertEquals(2, solve(new int[]{2, 2, 3, 7}));
        assertEquals(3, solve(new int[]{1, 5, 5}));
        assertEquals(4, solve(new int[]{3, 7, 7, 7}));
    }
}
