package strings.find_two_letters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Input: string made of chars A,B,C..Z
 * Problem: for the pair of chars X,Y return true if there's a substring starts with X and ends with Z
 */
public class FindTwoLetters {
    static final char[] INPUT =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    boolean[][] index;

    public FindTwoLetters(String input) throws NoSuchFieldException, IllegalAccessException {
        boolean[] visited = new boolean[INPUT.length];
        index = new boolean[INPUT.length][];
        for (int i = 0; i < index.length; i++) {
            index[i] = new boolean[INPUT.length];
        }

        final Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        final char[] inputRaw = (char[]) field.get(input);

        List<Character> charsInProcess = new ArrayList<>(INPUT.length);
        for (int i = 0; i < INPUT.length; i++) {
            charsInProcess.add(INPUT[i]);
        }
        byte[] counters = new byte[INPUT.length];

        // O(n)
        for (int i = 0; i < inputRaw.length; i++) {
            char c = inputRaw[i];
            Iterator it = charsInProcess.iterator();
            while (it.hasNext()) {
                Character key = (Character) it.next();
                if (visited[key.charValue() - 'A']) {
                    if (!index[key.charValue() - 'A'][c - 'A']) {
                        index[key.charValue() - 'A'][c - 'A'] = true;
                        counters[key.charValue() - 'A']++;
                        if (counters[key.charValue() - 'A'] == INPUT.length) {
                            it.remove();
                        }
                    }
                }
            }
            visited[c - 'A'] = true;
            if (charsInProcess.size() == 0) {
                break;
            }
        }
    }

    public boolean findTwoLetters(char x, char y) {
        return index[x - 'A'][y - 'A'];
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
