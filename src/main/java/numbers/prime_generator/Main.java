package numbers.prime_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Implementation of the Sieve of Eratosthenes
 * @see http://research.cs.wisc.edu/techreports/1990/TR909.pdf
 */
public class Main {
    public static List<Integer> getPrimeNumbers(int from, int to) {
        BitSet sieve = new BitSet(to+1);
        sieve.flip(0, to+1);
        sieve.set(0, false);
        sieve.set(1, false);

        int limit = (int) Math.sqrt(to);
        for (int p = 2; p <= limit;) {
            int n = p*p;
            while (n <= to) {
                sieve.set(n, false);
                n += p;
            }
            p += 1;
            while (!sieve.get(p) && p <= limit) {
                p += 1;
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int n = from; n <= to; n++) {
            if (sieve.get(n)) {
                results.add(n);
            }
        }
        return results;
    }

    public static boolean isPrimeNumber(int number, List<Integer> primes) {
        if (!isPrimeNumberFast(number)) return false;
        for (Integer prime : primes) {
            if (number % prime == 0) {
                return false;
            }
        }
        primes.add(number);
        return true;
    }


    public static boolean isPrimeNumberFast(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number == 5) return true;
        if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) return false;
        int i = 5;
        while (i*i < number) {
            if (number % i == 0 || number % (i+2) == 0) return false;
            i += 6;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testAmount = Integer.parseInt(reader.readLine());
        while ((testAmount--) > 0) {
            String[] data = reader.readLine().split(" ");
            List<Integer> primes = getPrimeNumbers(new Integer(data[0]), new Integer(data[1]));
            for (Integer num : primes) {
                System.out.println(num);
            }
            System.out.println();
        }
    }
}
