/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Idea: {Time: O(N)} use two-pointer approach'
        // fast&slow pointer to find the middle of the list

        // corner-cases
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        // dummy-node before head for later node-delition
        ListNode slow = new ListNode(-1, head);
        ListNode newHead = slow.next;

        // works both, for even and odd list-sizes
        // (in case of even size, 'fast' will be null)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // remove node after 'slow'
        slow.next = slow.next.next;

        return head;
    }
}