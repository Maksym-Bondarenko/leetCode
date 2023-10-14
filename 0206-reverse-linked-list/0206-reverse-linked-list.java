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
    public ListNode reverseList(ListNode head) {
//         // Idea 1: (Iterative)
//         // in loop through the LL, reverse at a time one 'arrow' by using 3 pointers:
//         // 'previous', 'current', 'next'
        
//         // corner-cases
//         if(head == null || head.next == null)
//             return head;
        
//         ListNode current = head;
//         ListNode previous = null;   // so by first iteration future tail (previous head) points to 0
        
//         while(current != null) {
//             ListNode tmp = current.next;    // 'tmp' for next Node
//             current.next = previous;        // changing direction
//             previous = current;             // move pointers one step forward for next iteration
//             current = tmp;
//         }
        
//         // return 'previous' as a head (previously tail-element, future 'head'), as 'current' is null
//         return previous;
        
        // Idea 2: (Recursive)
        // do one rotation of 'arrow' in one recursion-iteration
        // rotate it by setting '.next.next' pointer and set tail to null
        
        // exit-cases from recursion
        if(head == null || head.next == null)
            return head;
        
        // recursive call: suppose rest-part is already reversed
        ListNode reversedRest = reverseList(head.next);
        // ! attention to 'next.next' => reverse 'arrow' !
        head.next.next = head;
        // last element (tail)
        head.next = null;
        
        // return head (previously tail)
        return reversedRest;
    }
}