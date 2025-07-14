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
    public int getDecimalValue(ListNode head) {
        // Idea 1: (brute-force), save list's values in array while traversing it. During next iteration through the array - add powers of two from the head for obtaining value
        // Time: O(n), Space: O(n)

        // Idea 2: (bits operations), use shifts (>>) from the head of list to get 'cummulative' value while iterating
        // Time: O(n), Space: O(1)

        int resultValue = head.val;

        while(head.next != null) {
            resultValue = resultValue << 1;
            resultValue = resultValue | head.next.val;
            head = head.next;
        }

        return resultValue;
    }
}