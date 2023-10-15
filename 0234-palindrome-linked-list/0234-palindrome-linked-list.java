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
    public boolean isPalindrome(ListNode head) {
        // Idea: (iterative, fast-slow pointers, rotate LL)
        // Using two-pointers approach (fast and slow), reach the middle of LL.
        // Reverse the second part of LL (iteratively or recursvely).
        // Ensure that values from first original part of LL and second reversed part of LL are same.
        
        // edge-cases
        if(head == null || head.next == null)
            return true;
        
        // go to the middle of the list (two-pointers approach: fast & slow)
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse second half of the list
        slow = this.reverse(slow);
        
        // compare two sub-lists
        ListNode headA = head;
        ListNode headB = slow;
        
        while(headB != null) {
            if(headA.val != headB.val)
                return false;
            headA = headA.next;
            headB = headB.next;
        }
        
        return true;
    }
    
    // help-function for reversing the given list
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        next = this.reverse(next);
        head.next.next = head;
        head.next = null;
        return next;
        
        // if(head == null || head.next == null)
        //     return head;
        
        // ListNode previous = null;
        // ListNode current = head;
        // ListNode further = null;
        
        // while(current != null) {
        //     further = current.next;
        //     current.next = previous;
        //     previous = current;
        //     current = further;
        // }
        
        // return previous;
    }
}