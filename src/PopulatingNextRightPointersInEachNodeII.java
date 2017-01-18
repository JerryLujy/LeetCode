/**
 * <h1>117. Populating Next Right Pointers in Each Node II</h1>
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * <p>
 * Note: You may only use constant extra space.
 * For example, Given the following binary tree,
 * <pre>
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   7
 * </pre>
 * After calling your function, the tree should look like:
 * <pre>
 *     1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 * </pre>
 *
 * @author Jerry
 * @since 1/18/17
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode curr = root;
            for (; curr != null; curr = curr.next) {
                TreeLinkNode cousin = findFirstCousin(curr);
                if (curr.left != null) {
                    if (curr.right != null) {
                        curr.left.next = curr.right;
                        curr.right.next = cousin;
                    } else {
                        curr.left.next = cousin;
                    }
                } else if (curr.right != null) {
                    curr.right.next = cousin;
                }
            }
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = findFirstCousin(root);
            }
        }
    }

    private TreeLinkNode findFirstCousin(TreeLinkNode node) {
        for (; node.next != null; node = node.next) {
            if (node.next.left != null) {
                return node.next.left;
            }
            if (node.next.right != null) {
                return node.next.right;
            }
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
