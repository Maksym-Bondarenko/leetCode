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
    public boolean hasCycle(ListNode head) {
        // Idea 1: (Hash-Set) save nodes into HS while iterating LL.
        // If current Node is in HS -> return true.
        // Time: O(n), Size: O(n)
        
        // Idea 2: (two-pointers approach, fast & slow)
        // Start from the head two pointers: fast and slow.
        // If fast pointer reaches null (end of LL) -< return false.
        // If at some point slow == afst -> return true (fast pointer in circle 'overpassing' slow one)
        
        ListNode slow = head;
        ListNode fast = head;
        
        // ! need to check both, fast and fast.next, as we moving two steps at a time
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // check for circle
            if(slow == fast)
                return  true;
        }
        
        return false;
    }
}