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
    public ListNode deleteDuplicates(ListNode head) {
        // Idea: single-iteration through the list with 2 pointers.
        // If faster pointer is the same as slower (difference is always 1) -> remove node of faster pointer.
        // If second node is not same -> move both pointers.
        // As input list is sorted, duplicate can only follow the same node(s),
        // as soon as new value appears -> we can continue without saving its value.
        // ! Move pointers only if a node with one value followed by a node with differ value !
        // Time: O(n), Space: O(1), in-place

        // corner-cases (empty list or 1 element)
        if(head == null || head.next == null)
            return head;

        ListNode first = head.next;
        ListNode second = head;

        // at least 2 elements in the list
        while (first != null) {
            // check if the next node's value is the same as current'
            if (first.val == second.val) {
                // remove node (remove the link between 1st and 2d node + move 1st node further)
                second.next = first.next;
                first = first.next;
            } else {
                // move pointers
                second = first;
                first = first.next;
            }
        }

        return head;
    }
}