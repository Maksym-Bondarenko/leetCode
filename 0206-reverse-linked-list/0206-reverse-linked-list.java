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
        // Iterative  
//         if(head == null || head.next == null)
//             return head;
        
//         ListNode current = head;
//         ListNode previous = null;
        
//         while(current != null) {
//             ListNode tmp = current.next;
//             current.next = previous;
//             previous = current;
//             current = tmp;
//         }
        
//         return previous;
        
        // Recursive
        if(head == null || head.next == null)
            return head;
        
        ListNode reversedRest = reverseList(head.next);  // suppose already reversed part
        head.next.next = head;
        head.next = null;
        
        return reversedRest;
    }
}