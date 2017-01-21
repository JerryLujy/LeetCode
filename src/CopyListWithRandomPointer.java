import java.util.HashMap;
import java.util.Map;

/**
 * <h1>138. Copy List with Random Pointer</h1>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * @author Jerry
 * @since 1/20/17
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while (head != null) {
            RandomListNode newNode = oldToNew.get(head);
            if (newNode == null) {
                newNode = new RandomListNode(head.label);
                oldToNew.put(head, newNode);
            }
            RandomListNode newRandom = oldToNew.get(head.random);
            if (newRandom == null && head.random != null) {
                newRandom = new RandomListNode(head.random.label);
                oldToNew.put(head.random, newRandom);
            }
            newNode.random = newRandom;
            cur.next = newNode;
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
