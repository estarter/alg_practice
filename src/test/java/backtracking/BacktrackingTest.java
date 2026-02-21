package backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BacktrackingTest {

    private final Backtracking bt = new Backtracking();

    // N-Queens tests

    @Test
    void nQueens1() {
        List<List<String>> result = bt.solveNQueens(1);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList("Q"), result.get(0));
    }

    @Test
    void nQueens4() {
        List<List<String>> result = bt.solveNQueens(4);
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(".Q..", "...Q", "Q...", "..Q.")));
        assertTrue(result.contains(Arrays.asList("..Q.", "Q...", "...Q", ".Q..")));
    }

    @Test
    void nQueens8() {
        List<List<String>> result = bt.solveNQueens(8);
        assertEquals(92, result.size());
    }

    @Test
    void nQueens2HasNoSolution() {
        assertEquals(0, bt.solveNQueens(2).size());
    }

    @Test
    void nQueens3HasNoSolution() {
        assertEquals(0, bt.solveNQueens(3).size());
    }

    // Permutations tests

    @Test
    void permutationsOfSingleElement() {
        List<List<Integer>> result = bt.permutations(new int[]{1});
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result.get(0));
    }

    @Test
    void permutationsOfTwoElements() {
        List<List<Integer>> result = bt.permutations(new int[]{1, 2});
        assertEquals(2, result.size());
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(2, 1)));
    }

    @Test
    void permutationsOfThreeElements() {
        List<List<Integer>> result = bt.permutations(new int[]{1, 2, 3});
        assertEquals(6, result.size());
        assertTrue(result.contains(Arrays.asList(1, 2, 3)));
        assertTrue(result.contains(Arrays.asList(3, 2, 1)));
        assertTrue(result.contains(Arrays.asList(2, 1, 3)));
    }

    @Test
    void permutationsOfEmpty() {
        List<List<Integer>> result = bt.permutations(new int[]{});
        assertEquals(1, result.size());
    }

    // Combinations tests

    @Test
    void combinationsC4_2() {
        List<List<Integer>> result = bt.combinations(4, 2);
        assertEquals(6, result.size());
        assertTrue(result.contains(Arrays.asList(1, 2)));
        assertTrue(result.contains(Arrays.asList(1, 3)));
        assertTrue(result.contains(Arrays.asList(1, 4)));
        assertTrue(result.contains(Arrays.asList(2, 3)));
        assertTrue(result.contains(Arrays.asList(2, 4)));
        assertTrue(result.contains(Arrays.asList(3, 4)));
    }

    @Test
    void combinationsC5_3() {
        List<List<Integer>> result = bt.combinations(5, 3);
        assertEquals(10, result.size());
    }

    @Test
    void combinationsC5_1() {
        List<List<Integer>> result = bt.combinations(5, 1);
        assertEquals(5, result.size());
        assertTrue(result.contains(Arrays.asList(1)));
        assertTrue(result.contains(Arrays.asList(5)));
    }

    @Test
    void combinationsC5_5() {
        List<List<Integer>> result = bt.combinations(5, 5);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result.get(0));
    }
}
