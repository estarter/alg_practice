# Union-Find (Disjoint Set Union)

## Description

Union-Find is a data structure that tracks a set of elements partitioned into
disjoint (non-overlapping) subsets. It supports two primary operations efficiently:

- **Find**: Determine which subset a particular element belongs to.
- **Union**: Merge two subsets into a single subset.

## Use Cases

- **Connected components** in undirected graphs
- **Kruskal's Minimum Spanning Tree** algorithm
- **Cycle detection** in undirected graphs
- **Network connectivity** queries
- **Equivalence class** computation

## Optimizations

### Path Compression

During `find(x)`, make every node on the path from `x` to the root point directly
to the root. This flattens the tree structure, making future queries faster.

### Union by Rank

When merging two trees, attach the shorter tree under the root of the taller tree.
This keeps the tree height small.

### Combined

With both optimizations, operations run in O(α(N)) amortized time, where α is the
inverse Ackermann function — effectively constant for all practical inputs.

## Complexity

| Operation       | Time (amortized)  |
|-----------------|-------------------|
| `find(x)`       | O(α(N))           |
| `union(x, y)`   | O(α(N))           |
| `connected(x,y)`| O(α(N))           |
| Space           | O(N)              |
