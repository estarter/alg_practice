# Binary Search

Binary search is a search algorithm that finds the position of a target value within a sorted array by repeatedly dividing the search interval in half.

## Use cases

- Searching in sorted arrays
- Finding boundaries (first/last occurrence)
- Searching in rotated sorted arrays
- Finding peak elements in arrays

## Variants

### Classic binary search

Find the index of a target in a sorted array, or -1 if not found.

- Time complexity: O(log N)
- Space complexity: O(1)

### Search in rotated sorted array

A sorted array is rotated at some pivot (e.g., [4,5,6,7,0,1,2] is [0,1,2,4,5,6,7] rotated at pivot 3). Find the index of a target value, or -1 if not found.

- Time complexity: O(log N)
- Space complexity: O(1)

### Find peak element

A peak element is an element that is strictly greater than its neighbors. Find the index of any peak element. Array boundaries are treated as negative infinity.

- Time complexity: O(log N)
- Space complexity: O(1)
