/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // // Since we know input node is not last node, so nextNode will not be null
        // ListNode nextNode = node.next;
        // node.val = nextNode.val;
        // // 'removing' node
        // node.next = nextNode.next;
        // nextNode.next = null;
        
        // alternative (according to task we know that node.next is not null)
        node.val = node.next.val;
        node.next = node.next.next;
    }
}