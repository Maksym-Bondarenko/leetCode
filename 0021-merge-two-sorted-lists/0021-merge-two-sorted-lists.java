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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Recursive
        // exit-case
        if(list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        
        // reccurance
        if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

        // // Iterative
        // ListNode result = new ListNode(-1);
        // ListNode current = result;
        
        // while(list1 != null || list2 != null) {
        //     // add full list if another is ended
        //     if(list2 == null) {
        //         current.next = list1;
        //         current = current.next;
        //         break;
        //     } else if(list1 == null) {
        //         current.next = list2;
        //         current = current.next;
        //         break;
        //     }
            
        //     if(list1.val <= list2.val) {
        //         current.next = new ListNode(list1.val);
        //         current = current.next;
        //         list1 = list1.next;
        //     } else {
        //         current.next = new ListNode(list2.val);
        //         current = current.next;
        //         list2 = list2.next;
        //     }
        // }
        
        // return result.next;
    }
}