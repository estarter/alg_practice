package numbers.prime_generator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by estarter on 31/03/16.
 */
public class MainTest {

    @Test
    public void testIsPrimeNumberFast() {
        assertFalse(Main.isPrimeNumberFast(1));
        assertTrue(Main.isPrimeNumberFast(2));
        assertTrue(Main.isPrimeNumberFast(3));
        assertFalse(Main.isPrimeNumberFast(4));
        assertTrue(Main.isPrimeNumberFast(5));
        assertFalse(Main.isPrimeNumberFast(6));
        assertTrue(Main.isPrimeNumberFast(7));
        assertFalse(Main.isPrimeNumberFast(8));
        assertFalse(Main.isPrimeNumberFast(9));
        assertFalse(Main.isPrimeNumberFast(10));
        assertTrue(Main.isPrimeNumberFast(11));
        assertFalse(Main.isPrimeNumberFast(12));
        assertTrue(Main.isPrimeNumberFast(13));
        assertFalse(Main.isPrimeNumberFast(14));
        assertFalse(Main.isPrimeNumberFast(15));
        assertFalse(Main.isPrimeNumberFast(16));
        assertTrue(Main.isPrimeNumberFast(17));
        assertFalse(Main.isPrimeNumberFast(18));
        assertTrue(Main.isPrimeNumberFast(19));
        assertFalse(Main.isPrimeNumberFast(20));

        Integer[] primes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        List<Integer> primeList = Arrays.asList(primes);
        for (int i = 0; i < 100; i++) {
            assertEquals("test number " + i, primeList.contains(i), Main.isPrimeNumberFast(i));
        }
    }

    @Test
    public void testIsPrimeNumber() {
        Integer[] primes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283,
                293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419,
                421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547,
                557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661,
                673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811,
                821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
                953, 967, 971, 977, 983, 991, 997};
        List<Integer> primeList = Arrays.asList(primes);
        List<Integer> cache = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            assertEquals("test number " + i, primeList.contains(i), Main.isPrimeNumber(i, cache));
        }
    }

    @Test
    public void testGetPrimeNumbers() {
        assertArrayEquals(new Integer[]{3,5}, Main.getPrimeNumbers(3, 5).toArray(new Integer[]{}));

        assertArrayEquals(new Integer[]{2,3,5,7}, Main.getPrimeNumbers(1, 10).toArray(new Integer[]{}));

        assertArrayEquals(new Integer[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199}, Main.getPrimeNumbers(3, 200).toArray(new Integer[]{}));
    }
}