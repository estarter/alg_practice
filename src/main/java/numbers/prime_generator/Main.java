package numbers.prime_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by estarter on 31/03/16.
 */
public class Main {
    public static Integer[] getPrimeNumbers(int from, int to) {
        List<Integer> results = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            if (isPrimeNumber(i)) {
                results.add(i);
            }
        }
        return results.toArray(new Integer[]{});
    }



    public static boolean isPrimeNumber(int number) {
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
            Integer[] primes = getPrimeNumbers(new Integer(data[0]), new Integer(data[1]));
            for (Integer num : primes) {
                System.out.println(num);
            }
            System.out.println();
        }
    }
}
