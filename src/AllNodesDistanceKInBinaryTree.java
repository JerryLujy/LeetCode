import support.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <h1>863. All Nodes Distance K in Binary Tree</h1>
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * Return a list of the values of all nodes that have a distance K from the target node.
 * The answer can be returned in any order.
 * <p>
 * Example 1: Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2. Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * <p>
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * <p>
 * Note:
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 *
 * @author Jerry
 * @since 2/2/19
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        dfs(parents, root);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while (!q.isEmpty() && K-- > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null && visited.add(cur.left)) {
                    q.offer(cur.left);
                }
                if (cur.right != null && visited.add(cur.right)) {
                    q.offer(cur.right);
                }
                if (parents.containsKey(cur) && visited.add(parents.get(cur))) {
                    q.offer(parents.get(cur));
                }
            }
        }
        return q.stream().map(n -> n.val).collect(Collectors.toList());
    }

    private void dfs(Map<TreeNode, TreeNode> map, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
            dfs(map, root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(map, root.right);
        }
    }
}
