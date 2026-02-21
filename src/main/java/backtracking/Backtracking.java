package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    // O(N!) time, O(N^2) space per solution
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[] queens = new int[n]; // queens[row] = col
        solveNQueens(results, queens, 0, n);
        return results;
    }

    private void solveNQueens(List<List<String>> results, int[] queens, int row, int n) {
        if (row == n) {
            results.add(buildBoard(queens, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidPlacement(queens, row, col)) {
                queens[row] = col;
                solveNQueens(results, queens, row + 1, n);
            }
        }
    }

    private boolean isValidPlacement(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) return false;
        }
        return true;
    }

    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j == queens[i] ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }

    // O(N! * N) time, O(N) recursion depth
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(results, new ArrayList<>(), nums, used);
        return results;
    }

    private void permute(List<List<Integer>> results, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            permute(results, current, nums, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    // O(C(n,k) * k) time, O(k) recursion depth
    public List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        combine(results, new ArrayList<>(), 1, n, k);
        return results;
    }

    private void combine(List<List<Integer>> results, List<Integer> current, int start, int n, int k) {
        if (current.size() == k) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);
            combine(results, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }
}
