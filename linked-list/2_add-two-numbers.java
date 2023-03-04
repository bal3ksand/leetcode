/* https://leetcode.com/problems/add-two-numbers/ */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum % 10);
        int carry = sum / 10;
        l1 = l1.next;
        l2 = l2.next;

        ListNode prev = head;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            prev.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            prev = prev.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            prev.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            prev = prev.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            prev.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            prev = prev.next;
        }

        if (carry > 0)
            prev.next = new ListNode(carry);

        return head;
    }
}