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
    public int pairSum(ListNode head) {
        // Idea 1: revert second half of the list, with 2 pointers add all twin-sums to array and find max-element

        // Idea 2: use 2-pointers to find middle of list, fill array by moving pointers simultaneously, then find max-element in the array of twin-sums

        ListNode slow = head;
        ListNode fast = head;
        int size = 0;   // calculate 1/2 size of LL

         // find middle of LL (as LL-size is even and >= 2, no need to check "fast.next != null")
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            size++;
        }

        // renew LL-pointers and create array for calculating sum of twins (1/2 size of LL)
        fast = slow;    // fast: beginning of the second half of LL
        slow = head;    // slow: start of LL
        int[] twinSums = new int[size];

        // calculate twin sums (according to the rules, no need to check "fast.next != null")
        for (int i = 0; i < size; i++) {
            twinSums[i] += slow.val;               // add first-twin
            twinSums[size - 1 - i] += fast.val;    // add second-twin

            // move pointers
            slow = slow.next;
            fast = fast.next;
        }

        // find max-element in the new array
        return findMax(twinSums);
    }

    // help-function to find maximum element of the given int-array with positive values only
    private int findMax(int[] arr) {
        int maxElement = 0;

        for (int num : arr)
            maxElement = Math.max(maxElement, num);
        
        return maxElement;
    }
}