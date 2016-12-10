package sorting.sort_the_files;

import java.util.List;

/**
 * @author Alexey Merezhin
 */
class Solution {
    public static void sort_the_files(int n, List<String> result) {
        generate(n, 0, 0, result);
    }

    private static void generate(int n, int level, int filename, List<String> result) {
        if (result.size() > 1000) return;
        // if (result.size() >= n) return;
        if (filename > n) return;

        if (filename > 0) {
            result.add("IMG"+filename+".jpg");
        }

        for (int i = 0; i <= 9; i++) {
            if (level == 0 && i == 0) continue;
            generate(n, level+1, filename*10+i, result);
        }
    }
}
