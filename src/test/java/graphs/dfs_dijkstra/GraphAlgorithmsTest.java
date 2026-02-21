package graphs.dfs_dijkstra;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphAlgorithmsTest {

    // --- DFS tests ---

    @Test
    void dfs_singleNode() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Collections.emptyList());

        List<Integer> result = GraphAlgorithms.dfs(graph, 0);
        assertThat(result).containsExactly(0);
    }

    @Test
    void dfs_linearGraph() {
        // 0 -> 1 -> 2 -> 3
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Collections.emptyList());

        List<Integer> result = GraphAlgorithms.dfs(graph, 0);
        assertThat(result).containsExactly(0, 1, 2, 3);
    }

    @Test
    void dfs_graphWithCycle() {
        // 0 -> 1 -> 2 -> 0 (cycle)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0));

        List<Integer> result = GraphAlgorithms.dfs(graph, 0);
        assertThat(result).containsExactlyInAnyOrder(0, 1, 2);
        assertThat(result).hasSize(3);
    }

    @Test
    void dfs_branchingGraph() {
        //     1
        //    / \
        //   0   3
        //    \
        //     2
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Collections.emptyList());
        graph.put(3, Collections.emptyList());

        List<Integer> result = GraphAlgorithms.dfs(graph, 0);
        assertThat(result).containsExactlyInAnyOrder(0, 1, 2, 3);
        assertThat(result).startsWith(0);
    }

    @Test
    void dfs_disconnectedNodeNotVisited() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1));
        graph.put(1, Collections.emptyList());
        graph.put(2, Collections.emptyList()); // disconnected

        List<Integer> result = GraphAlgorithms.dfs(graph, 0);
        assertThat(result).containsExactlyInAnyOrder(0, 1);
        assertThat(result).doesNotContain(2);
    }

    // --- Dijkstra tests ---

    @Test
    void dijkstra_singleNode() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Collections.emptyList());

        Map<Integer, Integer> dist = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(0, (int) dist.get(0));
    }

    @Test
    void dijkstra_linearGraph() {
        // 0 -1-> 1 -2-> 2 -3-> 3
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 1}));
        graph.put(1, Arrays.asList(new int[]{2, 2}));
        graph.put(2, Arrays.asList(new int[]{3, 3}));
        graph.put(3, Collections.emptyList());

        Map<Integer, Integer> dist = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(0, (int) dist.get(0));
        assertEquals(1, (int) dist.get(1));
        assertEquals(3, (int) dist.get(2));
        assertEquals(6, (int) dist.get(3));
    }

    @Test
    void dijkstra_choosesShortestPath() {
        // 0 -10-> 2
        // 0 -1-> 1 -1-> 2
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 1}, new int[]{2, 10}));
        graph.put(1, Arrays.asList(new int[]{2, 1}));
        graph.put(2, Collections.emptyList());

        Map<Integer, Integer> dist = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(0, (int) dist.get(0));
        assertEquals(1, (int) dist.get(1));
        assertEquals(2, (int) dist.get(2));
    }

    @Test
    void dijkstra_complexGraph() {
        // 0 -4-> 1, 0 -1-> 2
        // 1 -1-> 3
        // 2 -2-> 1, 2 -5-> 3
        // shortest: 0->2->1->3 = 1+2+1 = 4
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 4}, new int[]{2, 1}));
        graph.put(1, Arrays.asList(new int[]{3, 1}));
        graph.put(2, Arrays.asList(new int[]{1, 2}, new int[]{3, 5}));
        graph.put(3, Collections.emptyList());

        Map<Integer, Integer> dist = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(0, (int) dist.get(0));
        assertEquals(3, (int) dist.get(1));
        assertEquals(1, (int) dist.get(2));
        assertEquals(4, (int) dist.get(3));
    }

    @Test
    void dijkstra_unreachableNode() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 5}));
        graph.put(1, Collections.emptyList());
        graph.put(2, Collections.emptyList()); // unreachable from 0

        Map<Integer, Integer> dist = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(0, (int) dist.get(0));
        assertEquals(5, (int) dist.get(1));
        assertEquals(Integer.MAX_VALUE, (int) dist.get(2));
    }
}
