package palindrome;

public class FormAPalindrome {

    public static int minPal_dp(String str) {
        int[][] cache = new int[str.length()][str.length()];
        for (int len = 1; len < str.length(); len++) {
            for (int i = 0; i < str.length() - len; i++) {
                int j = len + i;
                if (str.charAt(i) != str.charAt(j)) {
                    cache[i][j] = Math.min(cache[i][j - 1], cache[i + 1][j]) + 1;
                } else {
                    cache[i][j] = cache[i + 1][j - 1];
                }
            }
        }
        return cache[0][str.length() - 1];
    }

    public static int minPal_recursive(String str) {
        int[][] cache = new int[str.length()][str.length()];
        return minPal_rec(str, cache, 0, str.length() - 1);
    }

    private static int minPal_rec(String str, int[][] cache, int from, int to) {
        if (to - from < 1)
            return 0;
        if (cache[from][to] != 0)
            return cache[from][to];
        int res;
        if (str.charAt(from) == str.charAt(to)) {
            res = minPal_rec(str, cache, from + 1, to - 1);
        } else {
            res = 1 + Math.min(minPal_rec(str, cache, from + 1, to), minPal_rec(str, cache, from, to - 1));
        }
        cache[from][to] = res;
        return res;
    }

}

