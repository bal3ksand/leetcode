/* https://leetcode.com/problems/copy-list-with-random-pointer/ */

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        /* Create copies in original list */
        Node original = head;
        while (original != null) {
            Node copy = new Node(original.val);
            Node next = original.next;
            original.next = copy;
            copy.next = next;
            original = next;
        }

        /* Update random pointers of copies */
        original = head;
        while (original != null) {
            if (original.random != null)
                original.next.random = original.random.next;
            original = original.next.next;
        }

        /* Separate original list and deep copy */
        original = head;
        Node copy = head.next;
        Node headCopy = head.next;
        while (copy.next != null) {
            original.next = copy.next;
            copy.next = copy.next.next;
            original = original.next;
            copy = copy.next;
        }
        original.next = null;

        return headCopy;
    }
}