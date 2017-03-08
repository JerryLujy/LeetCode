import support.TreeNode;

import java.util.*;

/**
 * <h1>145. Binary Tree Postorder Traversal</h1>
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example: Given binary tree {1,#,2,3},
 * <pre>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </pre>
 * return [3,2,1].
 *
 * @author Jerry
 * @since 1/22/17
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Boolean> shouldVisit = new HashMap<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                shouldVisit.put(root, false);
                root = root.left;
            }
            root = stack.pop();
            if (shouldVisit.get(root)) {
                ans.add(root.val);
                root = null;
            } else {
                stack.push(root);
                shouldVisit.put(root, true);
                root = root.right;
            }
        }
        return ans;
    }
}
