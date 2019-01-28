import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <h1>426. Convert Binary Search Tree to Sorted Doubly Linked List</h1>
 * Convert a BST to a sorted circular doubly-linked list in-place.
 * Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
 *
 * @author Jerry
 * @since 1/27/19
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyListIterative(Node root) {
        if (root == null) {
            return null;
        }
        Node head = null, tail = null;
        Deque<Node> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (head == null) {
                head = root;
                tail = root;
            } else {
                tail.right = root;
                root.left = tail;
                tail = root;
            }
            root = root.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    public Node treeToDoublyListRecursive(Node root) {
        if (root == null) {
            return null;
        }
        Node[] ret = flatten(root);
        ret[0].left = ret[1];
        ret[1].right = ret[0];
        return ret[0];
    }

    private Node[] flatten(Node root) {
        Node[] ans = new Node[2];
        Arrays.fill(ans, root);
        if (root.left != null) {
            Node[] l = flatten(root.left);
            l[1].right = root;
            root.left = l[1];
            ans[0] = l[0];
        }
        if (root.right != null) {
            Node[] r = flatten(root.right);
            r[0].left = root;
            root.right = r[0];
            ans[1] = r[1];
        }
        return ans;
    }
    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
