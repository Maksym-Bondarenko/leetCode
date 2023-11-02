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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Idea 1: (ineffective) transform into array and do converting from sorted array into BST

        // Idea 2: (slow & fast pointers, recursive)
        // use slow&fast pointers approach to reach the middle of a LL.
        // Perform BST conversion as with the sorted array

        // corner-cases
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);

        // tail is null (last element, outside of boundaries)
        return sortedListRangesToBST(head, null);

        // // Idea 3: (recursive, alternative)
        // // without additional help-function

        // // edge-cases
        // if(head == null)
        //     return null;
        // if(head.next == null)
        //     return new TreeNode(head.val);

        // // get middle of the LL
        // ListNode slow = head;
        // ListNode fast = head.next.next;
        // while(fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // TreeNode res = new TreeNode(slow.next.val);
        // ListNode righthalf = slow.next.next;
        // slow.next = null;
        // res.left = sortedListToBST(head);
        // res.right = sortedListToBST(righthalf);
        // return res;
    }

    // recursive help-function that creates a node (middle element between head and tail)
    // and returns it
    private TreeNode sortedListRangesToBST(ListNode head, ListNode tail) {
        // exit from recursion (single element)
        if(head == tail)
            return null;

        // find middle element via slow&fast pointers approach
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        // reccurance
        root.left = sortedListRangesToBST(head, slow);
        root.right = sortedListRangesToBST(slow.next, tail);

        return root;
    }
}