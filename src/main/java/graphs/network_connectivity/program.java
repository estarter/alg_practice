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
        int nodesAmount = Integer.parseInt(metrics[0]);
        int linksAmount = Integer.parseInt(metrics[1]);
        int nodeId = Integer.parseInt(metrics[2]);

        Map<Integer, Node> nodes = new HashMap<>(nodesAmount);
        for (int i = 1; i <= nodesAmount; i++) {
            nodes.put(i, new Node(i));
        }

        while (linksAmount > 0) {
            linksAmount--;
            String[] link = scanner.readLine().split(" ");
            int node1 = Integer.parseInt(link[0]);
            int node2 = Integer.parseInt(link[1]);
            nodes.get(node1).linkedNodes.add(node2);
            nodes.get(node2).linkedNodes.add(node1);
        }

        int result = getReachableNodesAmount(nodes, nodeId);
        System.out.println(result);
    }

    static int getReachableNodesAmount(Map<Integer, Node> nodes, int nodeId) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(nodes.get(nodeId));
        int amount = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.visited = true;
            for (int id : node.linkedNodes) {
                Node linkedNode = nodes.get(id);
                if (!linkedNode.visited) {
                    amount++;
                    queue.add(linkedNode);
                    linkedNode.visited = true;
                }
            }
        }
        return amount;
    }
}

class Node {
    int id;
    boolean visited = false;
    List<Integer> linkedNodes = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }
}