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
        // // Idea 1: (Recursive)
        // // if some of lists is null -> return another list (it works because lists are sorted)
        // // else, take a smaller value from lists and append to it result of calling recursive function
        // // (with input values from both lists)
        
        // // exit-cases
        // if(list1 == null)
        //     return list2;
        // else if (list2 == null)
        //     return list1;
        
        // // reccurance (we know that both lists are not-null)
        // if(list1.val <= list2.val) {
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // } else {
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }

        // Idea 2: (Iterative)
        // untill both LL are empty (iterated) create a new node with smaller value
        // and append it to the result-LL.
        // If any of LL ended earlier -> append another to the result-LL.

        ListNode result = new ListNode(-1); // dummy-node
        ListNode current = result;          // for iterations

        // repeat untill both lists are empty        
        while(list1 != null || list2 != null) {
            // edge-cases: add full list if another is ended and finish
            if(list2 == null) {
                current.next = list1;
                break;
            } else if(list1 == null) {
                current.next = list2;
                break;
            }
            
            if(list1.val <= list2.val) {
                current.next = new ListNode(list1.val);
                list1 = list1.next; // move to new next value
            } else {
                current.next = new ListNode(list2.val);
                list2 = list2.next; // move to new next value
            }

            // step forward of result-LL
            current = current.next;
        }
        
        return result.next; // skip first dummy-value
    }
}