import java.util.*;

/**
 * <h1>314. Binary Tree Vertical Order Traversal</h1>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples: Given binary tree [3,9,20,null,null,15,7], return its vertical order traversal as: [[9],[3,15],[20],[7]]
 * <pre>
 *  3
 *  /\
 * /  \
 * 9  20
 *    /\
 *   /  \
 *  15   7
 * </pre>
 * Given binary tree [3,9,8,4,0,1,7], return its vertical order traversal as:[[4],[9],[3,0,1],[8],[7]]
 * <pre>
 *     3
 *     /\
 *    /  \
 *   9   8
 *  /\  /\
 * /  \/  \
 * 4  01   7
 * </pre>
 * Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 * return its vertical order traversal as:[[4],[9,5],[3,0,1],[8,2],[7]]
 * <pre>
 *     3
 *     /\
 *    /  \
 *   9   8
 *  /\  /\
 * /  \/  \
 * 4  01   7
 *    /\
 *   /  \
 *  5   2
 * </pre>
 *
 * @author Jerry
 * @since 2/16/17
 */
public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> colQueue = new ArrayDeque<>();

        nodeQueue.offer(root);
        colQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                nodeQueue.offer(node.left);
                colQueue.offer(col - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                colQueue.offer(col + 1);
            }
        }

        for (List<Integer> col : map.values()) {
            ans.add(col);
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
