# Backtracking

## What is Backtracking?

Backtracking is a general algorithmic technique that incrementally builds candidates to a solution and abandons ("backtracks") a candidate as soon as it determines the candidate cannot lead to a valid solution. It systematically explores all possible configurations using depth-first search with pruning.

### Use cases
- Constraint satisfaction problems (Sudoku, crosswords)
- Combinatorial problems (permutations, combinations, subsets)
- Puzzle solving (N-Queens, knight's tour)
- Path finding in graphs/mazes

## Problems

### N-Queens

Place N queens on an NxN chessboard such that no two queens threaten each other (no two queens share the same row, column, or diagonal).

- Input: integer N
- Output: all valid board configurations
- Time complexity: O(N!)
- Space complexity: O(N^2) per solution for the board representation

### Permutations

Generate all permutations of a given array of distinct integers.

- Input: array of integers
- Output: all possible orderings
- Time complexity: O(N! * N)
- Space complexity: O(N) recursion depth + O(N! * N) for results

### Combinations

Generate all combinations of K elements chosen from 1..N (C(N, K)).

- Input: integers N and K
- Output: all subsets of size K
- Time complexity: O(C(N,K) * K)
- Space complexity: O(K) recursion depth + O(C(N,K) * K) for results
