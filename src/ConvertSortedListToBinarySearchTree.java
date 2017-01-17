/**
 * <h1>109. Convert Sorted List to Binary Search Tree</h1>
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author Jerry
 * @since 1/16/17
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode walker = head, runner = head;
        while (runner != tail && runner.next != tail) {
            runner = runner.next.next;
            walker = walker.next;
        }
        TreeNode root = new TreeNode(walker.val);
        root.left = sortedListToBST(head, walker);
        root.right = sortedListToBST(walker.next, tail);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
