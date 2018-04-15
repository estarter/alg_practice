package longest_inc_subseq;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
class MainTest {
    static final Logger LOG = Logger.getLogger(MainTest.class.getName());

    @Test
    void testSeq() {
        Integer[] seq = Main.findLongestIncSubseq(new Integer[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
        assertArrayEquals(new Integer[]{0, 2, 6, 9, 11, 15}, seq);

        seq = Main.findLongestIncSubseq(new Integer[]{2984, 1743, 8889, 3708, 8747, 6831, 2570, 6473, 9962, 241});
        assertArrayEquals(new Integer[]{1743, 2570, 6473, 9962}, seq);
    }

    @Test
    void testSeq2() {
        List<Integer> seq;
        seq = Main.longest_increasing_subsequence(Arrays.asList(16, 3, 5, 19, 10, 14, 12, 0, 15));
        assertEquals(seq, Arrays.asList(3, 5, 10, 12, 15));

        seq = Main.longest_increasing_subsequence(Arrays.asList(14));
        assertEquals(seq, Arrays.asList(14));

        seq = Main.longest_increasing_subsequence(Arrays.asList(10, 8, 6, 4, 2, 0));
        assertEquals(seq, Arrays.asList(0));

        seq = Main.longest_increasing_subsequence(Arrays.asList(2984, 1743, 8889, 3708, 8747, 6831, 2570, 6473, 9962, 241));
        assertEquals(seq, Arrays.asList(1743, 2570, 6473, 9962));
    }

    @Test
    void crossTest() {
        int testSize = 100;
        for (int k = 0; k < 5; k++) {
            Random randomGenerator = new Random();
            List<Integer> input = new ArrayList<>(testSize);
            for (int i = 0; i < testSize; i++) {
                input.add(randomGenerator.nextInt(Math.min(testSize * 1000, Integer.MAX_VALUE)));
            }

            long startTime = System.nanoTime();
            Integer[] result1 = Main.findLongestIncSubseq(input.toArray(new Integer[]{}));
            LOG.info("first  " + (System.nanoTime() - startTime));

            startTime = System.nanoTime();
            List<Integer> result2 = Main.longest_increasing_subsequence(input);
            LOG.info("second " + (System.nanoTime() - startTime));

            LOG.info(input.toString());
            assertEquals(result2, Arrays.asList(result1), input.toString());
        }
    }
}