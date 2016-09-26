package count_the_paths;

import java.util.List;

/**
 * @author Alexey Merezhin
 */
public class Solution {
    public static int count_the_paths(List<String> grid) {
        if (grid.size() == 0) return 0;
        grid.remove("");
        int N = grid.size();
        int M = grid.get(0).length();
        int[][] moveCounts = new int[N][];
        for (int i = 0; i < moveCounts.length; i++) {
            moveCounts[i] = new int[M];
        }
        moveCounts[N-1][0] = 1;

        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (moveCounts[i][j] == 0) {
                    try {
                    if (grid.get(i).charAt(j) == '1') {
                        moveCounts[i][j] = 0;
                    } else {
                        int down = i < (N - 1) ? moveCounts[i+1][j] : 0;
                        int left = j > 0 ? moveCounts[i][j-1] : 0;
                        moveCounts[i][j] = down + left;
                    }
                    } catch (Exception e) {
                        String xx = "\n";
                        for (int k = 0; k < N; k++) {
                            xx += grid.get(k) + "\n";
                        }
                        throw new RuntimeException("access char " + j + " i: " + i + " str '" + grid.get(i) + "' grid :" + xx);
                    }
                }
            }
        }

        return moveCounts[0][M-1];
    }
}
