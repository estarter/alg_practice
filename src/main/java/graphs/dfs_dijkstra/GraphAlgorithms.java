package graphs.dfs_dijkstra;

import java.util.*;

public class GraphAlgorithms {

    // O(V + E) time, O(V) space
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> visited = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);
        seen.add(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited.add(node);

            List<Integer> neighbors = graph.getOrDefault(node, Collections.emptyList());
            for (int neighbor : neighbors) {
                if (!seen.contains(neighbor)) {
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }

        return visited;
    }

    // O((V + E) log V) time, O(V) space
    public static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int source) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }
        dist.put(source, 0);

        // {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, source});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];

            if (d > dist.getOrDefault(u, Integer.MAX_VALUE)) {
                continue;
            }

            for (int[] edge : graph.getOrDefault(u, Collections.emptyList())) {
                int v = edge[0];
                int weight = edge[1];
                int newDist = d + weight;
                if (newDist < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, newDist);
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        return dist;
    }
}
