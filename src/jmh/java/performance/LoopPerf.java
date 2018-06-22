package performance;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class LoopPerf {
    private static final int[] arr = new int[100];
    static {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }
    private static final int exp = 4950;

    // @Benchmark
    public void classicIter() {
        int res = 0;
        int i = 0;
        try {
            while (true) {
                res += arr[i++];
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        assertEquals(exp, res);
    }

    // @Benchmark
    public void exceptionIter() {
        int res = 0;
        for (int i : arr) {
            res += i;
        }
        assertEquals(exp, res);
    }

}
