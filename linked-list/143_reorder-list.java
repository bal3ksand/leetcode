/* https://leetcode.com/problems/reorder-list/ */

class Solution {
    public void reorderList(ListNode head) {
        /* Find length of list */
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        /* Reverse 2nd half of list */
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < len / 2; i++)
            p2 = p2.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode head2 = p1.next;
        p1.next = null;

        p1 = null;
        p2 = head2;
        while (p2 != null) {
            curr = p2;
            p2 = p2.next;
            curr.next = p1;
            p1 = curr;
        }
        head2 = p1;

        /* Interweave 1st half of list and the reversed 2nd half */
        p1 = head;
        p2 = head2;
        while (p2 != null) {
            ListNode curr1 = p1.next;
            p1.next = p2;
            ListNode curr2 = p2.next;
            p2.next = curr1;
            p1 = curr1;
            p2 = curr2;
        }
    }
}