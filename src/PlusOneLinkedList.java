/**
 * <h1>369. Plus One Linked List</h1>
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example: Input: 1->2->3, Output: 1->2->4
 *
 * @author Jerry
 * @since 3/5/17
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        int val = 1;
        cur = prev;
        prev = null;
        while (cur != null) {
            cur.val += val;
            val = cur.val / 10;
            cur.val %= 10;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        if (val != 0) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
