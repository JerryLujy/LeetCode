import support.ListNode;

/**
 * <h1>160. Intersection of Two Linked Lists</h1>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <pre>
 * A:        a1 -> a2
 *                   \
 *                    c1 -> c2 -> c3
 *                   /
 * B:  b1 -> b2 -> b3
 * </pre>
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
