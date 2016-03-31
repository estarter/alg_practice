package strings.find_two_letters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Input: string made of chars A,B,C..Z
 * Problem: for the pair of chars X,Y return true if there's a substring starts with X and ends with Z
 */
public class FindTwoLetters {
    static final char[] INPUT =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    int[] firstIdx = new int[INPUT.length];
    int[] lastIdx = new int[INPUT.length];

    public FindTwoLetters(String input) throws NoSuchFieldException, IllegalAccessException {
        Arrays.fill(firstIdx, -1);
        Arrays.fill(lastIdx, -1);

        final Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        final char[] inputRaw = (char[]) field.get(input);

        for (int i = 0; i < inputRaw.length; i++) {
            int idx = inputRaw[i] - 'A';
            if (firstIdx[idx] < 0) {
                firstIdx[idx] = i;
            }
            lastIdx[idx] = i;
        }
    }

    public boolean findTwoLetters(char x, char y) {
        return lastIdx[y - 'A'] > firstIdx[x - 'A'];
    }

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FindTwoLetters ftl = new FindTwoLetters(reader.readLine());
        int testAmount = Integer.parseInt(reader.readLine());
        while ((testAmount--) > 0) {
            String data = reader.readLine();
            if (ftl.findTwoLetters(data.charAt(0), data.charAt(2))) {
                System.out.println("YA");
            } else {
                System.out.println("TIDAK");
            }
        }
    }
}
