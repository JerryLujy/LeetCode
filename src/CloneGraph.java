import java.util.*;

/**
 * <h1>133. Clone Graph</h1>
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * @author Jerry
 * @since 1/20/17
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<>();
        oldToNew.put(node, new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode next : cur.neighbors) {
                if (!oldToNew.containsKey(next)) {
                    oldToNew.put(next, new UndirectedGraphNode(next.label));
                    queue.offer(next);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(next));
            }
        }
        return oldToNew.get(node);
    }

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<>();
        return dfs(node, oldToNew);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew) {
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        oldToNew.put(node, newNode);
        for (UndirectedGraphNode next : node.neighbors) {
            newNode.neighbors.add(dfs(next, oldToNew));
        }
        return newNode;
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
