/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Idea: find weather it is a cycle using two-pointers approach (fast & slow)
        // if it is a cycle: is has to be in exact node, where start-node and slow-node met

        // edge-cases
        if(head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        
        // find a cycle
        do {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == null || fast.next == null)
                return null;    // no cycle in list
        } while(fast != slow);
        
        // find begin of cycle
        ListNode begin = head;
        while(begin != slow) {
            begin = begin.next;
            slow = slow.next;
        }
        
        return begin;   // begin and slow are pointing to exact node where cycle starts
    }
}