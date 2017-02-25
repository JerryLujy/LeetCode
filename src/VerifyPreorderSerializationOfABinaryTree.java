import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>331. Verify Preorder Serialization of a Binary Tree</h1>
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 * <pre>
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * </pre>
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
 * Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1: "9,3,4,#,#,1,#,#,2,#,6,#,#", Return true
 * <p>
 * Example 2: "1,#", Return false
 * <p>
 * Example 3: "9,#,#,1", Return false
 *
 * @author Jerry
 * @since 2/25/17
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        // Keep chopping leaf nodes until there is only one node
        for (String token : tokens) {
            if (token.equals("#")) {
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(token);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
