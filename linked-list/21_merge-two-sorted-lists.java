/* https://leetcode.com/problems/merge-two-sorted-lists/description/ */

class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null)
            return b;
        else if (b == null)
            return a;
        ListNode head;
        ListNode curr;
        if (a.val < b.val) {
            head = a;
            a = a.next;
        }
        else {
            head = b;
            b = b.next;
        }
        curr = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                curr = curr.next;
                a = a.next;
            }
            else {
                curr.next = b;
                curr = curr.next;
                b = b.next;
            }
        }
        while (a != null) {
            curr.next = a;
            curr = curr.next;
            a = a.next;
        }
        while (b != null) {
            curr.next = b;
            curr = curr.next;
            b = b.next;
        }
        return head;
    }
}