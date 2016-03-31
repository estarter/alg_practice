package strings.find_two_letters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Input: string made of chars A,B,C..Z
 * Problem: for the pair of chars X,Y return true if there's a substring starts with X and ends with Z
 */
public class FindTwoLetters {
    static final char[] INPUT =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    HashMap<Character, Set<Character>> index;

    public FindTwoLetters(String input) {
        index = new HashMap<>();
        for (char key : INPUT) {
            int firstIdx = input.indexOf(key);
            if (firstIdx >= 0) {
                Set<Character> endChars = new TreeSet<>();
                for (char end : INPUT) {
                    if (input.indexOf(end, firstIdx) > 0) {
                        endChars.add(end);
                    }
                }
                index.put(key, endChars);
            }
        }
    }

    public boolean findTwoLetters(char x, char y) {
        if (index.containsKey(x)) {
            return index.get(x).contains(y);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
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
