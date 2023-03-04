/* https://leetcode.com/problems/reverse-linked-list/description/ */

class Solution {
    public ListNode reverseList(ListNode head) {
        return rec(null, head);
    }
    public ListNode rec(ListNode a, ListNode b) {
        if (b == null)
            return a;
        ListNode curr = b;
        b = b.next;
        curr.next = a;
        return rec(curr, b);
    }
}