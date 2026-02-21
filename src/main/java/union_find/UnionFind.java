package union_find;

/**
 * Union-Find (Disjoint Set Union) with path compression and union by rank.
 * All operations run in O(α(N)) amortized time, where α is the inverse Ackermann function.
 */
public class UnionFind {

    private final int[] parent;
    private final int[] rank;
    private int componentCount;

    // O(N)
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        componentCount = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // O(α(N)) amortized — path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // O(α(N)) amortized — union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        componentCount--;
    }

    // O(α(N)) amortized
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    // O(1)
    public int componentCount() {
        return componentCount;
    }
}
