import java.util.*;

/**
 * <h1>133. Clone Graph</h1>
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * @author Jerry
 * @since 1/20/17
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            if (visited.contains(curr)) {
                continue;
            }
            visited.add(curr);
            if (!oldToNew.containsKey(curr)) {
                oldToNew.put(curr, new UndirectedGraphNode(curr.label));
            }
            UndirectedGraphNode currDup = oldToNew.get(curr);
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!oldToNew.containsKey(neighbor)) {
                    oldToNew.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                currDup.neighbors.add(oldToNew.get(neighbor));
                queue.offer(neighbor);
            }
        }
        return oldToNew.get(node);
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
