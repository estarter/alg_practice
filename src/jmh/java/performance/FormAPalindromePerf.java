package performance;

import static palindrome.FormAPalindrome.minPal_dp;
import static palindrome.FormAPalindrome.minPal_recursive;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.openjdk.jmh.annotations.Benchmark;

public class FormAPalindromePerf {

    private static final String[] data;// = { "aba", "abca", "abcadad" };

    static {
        data = new String[1000];
        Random random = new Random();
        int bound = 50;
        for (int i = 0; i < data.length; i++) {
            data[i] = RandomStringUtils.random(random.nextInt(bound) + 2, true, false);
        }
    }

    @Benchmark
    public void bench_dp() {
        for (String str : data) {
            minPal_dp(str);
        }
    }

    @Benchmark
    public void bench_recursive() {
        for (String str : data) {
            minPal_recursive(str);
        }
    }
}
