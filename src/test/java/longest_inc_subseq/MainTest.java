package longest_inc_subseq;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Alexey Merezhin
 */
public class MainTest {
    @Test
    public void testSeq() throws Exception {
        Main main = new Main();
        Integer[] seq = main.findLongestIncSubseq(new Integer[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
        System.out.println(Arrays.toString(seq));
        assertArrayEquals(new Integer[]{0, 2, 6, 9, 11, 15}, seq);

    }
}