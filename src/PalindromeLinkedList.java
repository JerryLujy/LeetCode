import support.ListNode;

/**
 * <h1>234. Palindrome Linked List</h1>
 * Given a singly linked list, determine if it is a palindrome.
 *
 * @author Jerry
 * @since 2/2/17
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head, runner = head;
        while (runner != null && runner.next != null) {
            cur = cur.next;
            runner = runner.next.next;
        }
        if (runner != null) {
            cur = cur.next; // At mid point
        }
        // Reverse second half;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur = prev;
        prev = null;
        // Check palindrome while restoring list
        boolean isPalindrome = true;
        while (cur != null) {
            if (head.val != cur.val) {
                isPalindrome = false;
            }
            head = head.next;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return isPalindrome;
    }
}
