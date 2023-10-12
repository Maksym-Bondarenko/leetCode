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
    public ListNode removeNthFromEnd(ListNode head, int n) {
//         // Idea 1: (2 passes) iterate the LL first time to count amount of elements (nodes)
//         // Iterate the LL second time by (LL-size minus n)-times, removing the next node
//         // Time: O(n), Space: O(1) > Actually 2 passes through LL
        
//         // edge-cases
//         if(head == null || head.next == null)
//             return null;
        
//         int size = 0;
        
//         // get size of LL
//         for(ListNode current = head; current != null; current = current.next)
//             size++;
        
//         ListNode current = head;   // one node before, is pointing to node to be removed
        
//         // iterate LL to one node before Nth from the back (that needs to be removed)
//         for(int i = 0; i < size - n - 1; i++)
//             current = current.next;
        
//         // (if it is last node -> point to null)
//         // (if it is head-node -> return it's next one)
//         if(size - n == 0)
//             return head.next;
        
//         // remove next node
//         current.next = current.next.next;
        
//         return head;
        
        // Idea 2: (one-pass, more eligant; two-pointers approach)
        // we can get n-th node from the end by moving two pointers:
        // one from the beginning and one at the n-th position.
        // When first pointer reaches the end of LL,
        // second will point to the n-th node from the end
        // Time: O(n), Size: O(1)
        // Runtime: 0ms (100%), Memory: 40.3MB (41.86%)
        
        ListNode beforeHead = new ListNode(-1); // dummy-node
        beforeHead.next = head;
        ListNode first = head;                  // for iterating through array and finding n-th node
        ListNode second = beforeHead;           // for removing  node (should be before that node -> so 1 node before 'first')
        
        for(int i = 0; i < n; i++)
            first = first.next; // 'first' will point to (n+1) node
        
        while(first != null) {
            // move both pointers
            second = second.next;
            first = first.next;
        }
        
        // 'second' now point to the node, before one to be removed; 'first' points to null (after last element)
        second.next = second.next.next;
        return beforeHead.next; // return head (needs 'beforeHead' if old 'head' needs to be removed)
    }
}