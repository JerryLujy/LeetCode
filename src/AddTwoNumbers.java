import support.ListNode;

/**
 * <h1>2. Add Two Numbers</h1>
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <p>
 * Output: 7 -> 0 -> 8
 *
 * @author Jerry
 * @since 5/24/16
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry == 1) {
                return new ListNode(1);
            }
            return null;
        }
        if (l1 == null) {
            l2.val += carry;
            if (l2.val == 10) {
                l2.val = 0;
                l2.next = addTwoNumbersHelper(null, l2.next, 1);
            }
            return l2;
        }
        if (l2 == null) {
            l1.val += carry;
            if (l1.val == 10) {
                l1.val = 0;
                l1.next = addTwoNumbersHelper(l1.next, null, 1);
            }
            return l1;
        }
        int sum = l1.val + l2.val + carry;
        ListNode rst = new ListNode(sum % 10);
        rst.next = addTwoNumbersHelper(l1.next, l2.next, sum / 10);
        return rst;
    }
}
