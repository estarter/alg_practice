package strings.count_string_occurance;

/**
 * @author Alexey Merezhin
 */
import java.util.Scanner;

public class program {
    static int MULT = 26;
    static int MOD = 30;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String pat = input.nextLine();

        int count = getCount(str, pat);
        System.out.println("" + count);
    }

    public static int getCount(String str, String pat) {
        int targetHash = 0;
        for (int j = 0; j < pat.length(); j++) {
            targetHash += getHashNum(pat, j);
            if (j < pat.length()-1) {
                targetHash *= MULT;
                targetHash = targetHash % MOD;
            }
        }

        int count = 0;
        int hash = 0;
        int lastPow = (int) Math.pow(MULT, pat.length()-1);
        for (int i = 0; i < str.length(); i++) {
            if (i >= pat.length()) {
                hash -= getHashNum(str, i - pat.length())*lastPow % MOD;
                if (hash < 0) hash += MOD;
            }
            hash *= MULT;
            hash += getHashNum(str, i);
            hash = hash % MOD;
            if (hash == targetHash) count++;
        }
        return count;
    }

    static int getHashNum(String s, int pos) {
        return (s.charAt(pos) - 'a') + 1;
    }
}