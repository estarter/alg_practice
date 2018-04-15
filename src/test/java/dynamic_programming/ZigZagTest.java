package dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
class ZigZagTest {

    @Test
    void officialTestCases() {
        ZigZag zz = new ZigZag();
        assertEquals(6, zz.longestZigZag(new int[]{ 1, 7, 4, 9, 2, 5 }));
        assertEquals(7, zz.longestZigZag(new int[]{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
        assertEquals(1, zz.longestZigZag(new int[]{44}));
        assertEquals(8, zz.longestZigZag(new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7,
                5, 5, 5, 1000, 32, 32 }));
        assertEquals(36, zz.longestZigZag(new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }));
    }
}