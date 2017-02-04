import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>255. Verify Preorder Sequence in Binary Search Tree</h1>
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * <p>
 * You may assume each number in the sequence is unique.
 *
 * @author Jerry
 * @since 2/4/17
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : preorder) {
            if (i < low) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < i) {
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}
