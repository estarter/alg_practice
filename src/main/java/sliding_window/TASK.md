# Sliding Window / Two Pointers

## Sliding Window Technique

The sliding window technique maintains a window (subarray/substring) over a sequence and slides it to efficiently compute results. Instead of recalculating from scratch for each position, the window adjusts incrementally.

### Use cases
- Fixed-size subarray aggregations (max/min/average of k elements)
- Variable-size subarray problems (smallest subarray meeting a condition)
- Substring problems (longest substring with constraints)

## Two Pointers Technique

Two pointers uses two indices that move through a sorted or structured sequence, typically converging from both ends or advancing from the same end.

### Use cases
- Pair finding in sorted arrays (two sum, pair with target difference)
- Removing duplicates in-place
- Partitioning arrays

## Implemented Problems

### 1. Max Sum Subarray of Size K
Find the maximum sum among all contiguous subarrays of exactly size k.
- Time: O(N), Space: O(1)

### 2. Smallest Subarray with Sum >= Target
Find the length of the smallest contiguous subarray whose sum is greater than or equal to the target value. Returns 0 if no such subarray exists.
- Time: O(N), Space: O(1)

### 3. Longest Substring Without Repeating Characters
Find the length of the longest substring that contains no duplicate characters.
- Time: O(N), Space: O(min(N, alphabet size))

### 4. Two Sum (Sorted Array)
Given a sorted array and a target, find two numbers that add up to the target. Returns 1-based indices.
- Time: O(N), Space: O(1)
