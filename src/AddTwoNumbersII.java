import support.ListNode;

/**
 * <h1>445. Add Two Numbers II</h1>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example: Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4), Output: 7 -> 8 -> 0 -> 7
 *
 * @author Jerry
 * @since 2/8/17
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode prev = null;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum += val1 + val2;

            ListNode curr = new ListNode(sum % 10);
            curr.next = prev;
            prev = curr;
            sum /= 10; // sum is now the carry value
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return prev;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
