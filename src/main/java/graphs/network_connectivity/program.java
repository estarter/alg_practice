package graphs.network_connectivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Alexey Merezhin
 */
public class program {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String[] metrics = scanner.readLine().split(" ");
        int nodeAmount = Integer.parseInt(metrics[0]);
        int linksAmount = Integer.parseInt(metrics[1]);
        int nodeId = Integer.parseInt(metrics[2])-1;

        List<Integer>[] neighbours = new List[nodeAmount];
        for (int i = 0; i < nodeAmount; i++) {
            neighbours[i] = new ArrayList<>();
        }

        for (; linksAmount > 0; linksAmount--) {
            String[] edge = scanner.readLine().split(" ");
            int node1 = Integer.parseInt(edge[0])-1;
            int node2 = Integer.parseInt(edge[1])-1;
            neighbours[node1].add(node2);
            neighbours[node2].add(node1);
        }

        int result = 0;
        boolean[] visited = new boolean[nodeAmount]; // all nodes are unvisited
        LinkedList<Integer> queue = new LinkedList();
        queue.add(nodeId);
        visited[nodeId] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer linkedNode : neighbours[node]) {
                if (!visited[linkedNode]) {
                    queue.add(linkedNode);
                    visited[linkedNode] = true;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
