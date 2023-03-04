/* https://leetcode.com/problems/remove-nth-node-from-end-of-list/ */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }
        if (arr.size() == n)
            return head.next;
        curr = arr.get(arr.size() - n - 1);
        curr.next = curr.next.next;
        return head;
    }
}