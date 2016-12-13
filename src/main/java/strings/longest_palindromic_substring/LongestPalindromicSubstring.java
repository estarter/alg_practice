package strings.longest_palindromic_substring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexey Merezhin
 */
public class LongestPalindromicSubstring {
    public String longestPalSubstr(String str){
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            result = expandAroundCenter(str, result, i, i);
            result = expandAroundCenter(str, result, i, i+1);
        }

        return result;
    }

    private String expandAroundCenter(String str, String result, int from, int to) {
        while (from >= 0 && to < str.length()) {
            if (str.charAt(from) == str.charAt(to)) {
                if (to - from + 1 > result.length()) {
                    result = str.substring(from, to+1);
                }
            } else {
                break;
            }
            from--;
            to++;
        }
        return result;
    }

    @Test
    public void test() {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        assertEquals("A", lps.longestPalSubstr("A"));
        assertEquals("AA", lps.longestPalSubstr("AA"));
        assertEquals("AAA", lps.longestPalSubstr("AAA"));
        assertEquals("BBB", lps.longestPalSubstr("ABBB"));
    }

}
