package strings.find_two_letters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Input: string made of chars A,B,C..Z
 * Problem: for the pair of chars X,Y return true if there's a substring starts with X and ends with Z
 */
public class FindTwoLetters {
    static final char[] INPUT =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static final int FULL_INDEX = INPUT.length * INPUT.length;
    boolean[][] index;

    public FindTwoLetters(String input) {
        boolean[] visited = new boolean[INPUT.length];
        index = new boolean[INPUT.length][];
        for (int i = 0; i < index.length; i++) {
            index[i] = new boolean[INPUT.length];
        }

        int counter = 0;
        // O(n)
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int j = 0; j < index.length; j++) {
                if (visited[j]) {
                    if (!index[j][c - 'A']) {
                        index[j][c - 'A'] = true;
                        counter++;
                    }
                }
            }
            visited[c - 'A'] = true;
            if (counter >= FULL_INDEX) {
                break;
            }
        }
    }

    public boolean findTwoLetters(char x, char y) {
        return index[x - 'A'][y - 'A'];
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
