package numbers.prime_generator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by estarter on 31/03/16.
 */
public class MainTest {

    @Test
    public void testGetPrimeNumbers3_5() {
        assertArrayEquals(new Integer[]{3, 5}, Main.getPrimeNumbers(3, 5).toArray(new Integer[]{}));
    }

    @Test
    public void testGetPrimeNumbers1_10() {
        assertArrayEquals(new Integer[]{2, 3, 5, 7}, Main.getPrimeNumbers(1, 10).toArray(new Integer[]{}));
    }

    @Test
    public void testGetPrimeNumbers3_200() {
        assertArrayEquals(new Integer[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
                193, 197, 199}, Main.getPrimeNumbers(3, 200).toArray(new Integer[]{}));
    }

    @Test
    public void testGetPrimeNumbers11_20() {
        assertArrayEquals(new Integer[]{11, 13, 17, 19}, Main.getPrimeNumbers(11, 20).toArray(new Integer[]{}));
    }

    @Test
    public void testGetPrimeNumbersBig() {
        assertArrayEquals(new Integer[]{40009, 40013}, Main.getPrimeNumbers(40000, 40020).toArray(new Integer[]{}));
    }

    @Test
    public void testMain() throws IOException {
        String data = "2\n" +
                "1 10\n" +
                "3 5\n";
        InputStream stdin = System.in;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(outContent));
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Main.main(new String[]{});
            assertEquals("2\n" +
                    "3\n" +
                    "5\n" +
                    "7\n" +
                    "\n" +
                    "3\n" +
                    "5\n" +
                    "\n", outContent.toString());
        } finally {
            System.setIn(stdin);
            System.setOut(null);
        }


    }

}