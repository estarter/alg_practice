# DFS and Dijkstra's Algorithm

## Depth-First Search (DFS)

DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking.

### Use cases
- Topological sorting
- Cycle detection
- Pathfinding in mazes
- Connected component detection
- Solving puzzles (e.g., Sudoku)

### Complexity
- Time: O(V + E) where V = vertices, E = edges
- Space: O(V) for the visited set and recursion stack

## Dijkstra's Algorithm

Dijkstra's algorithm finds the shortest path from a source vertex to all other vertices in a weighted graph with non-negative edge weights.

### Use cases
- GPS navigation / route planning
- Network routing protocols
- Shortest path in weighted graphs

### Complexity
- Time: O((V + E) log V) with a priority queue (binary heap)
- Space: O(V) for distances and priority queue
