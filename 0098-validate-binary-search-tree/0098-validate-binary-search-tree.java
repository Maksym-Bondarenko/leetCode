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
    public boolean isValidBST(TreeNode root) {
        // // Idea 1: (Recursive traversal with valid range)
        // // Use helper-function with adjustable valid-range (min-max) for children-nodes.
        // // Call recursive for all nodes, changing the range according to node-value.
        
        // // range for root is infinitive
        // // use null instead of Integer.MIN_VALUE / Integer.MAX_VALUE
        // // to allow node-value have min/max possible values
        // return isValidBSTHelper(root, null, null);
        
        // Idea 2: (iterative in-order traversal)
        // while traversing in-order, check for valid BST

        // exit from recursion
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            // push to stack all left-children (iterate down-left the BST)
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // get last (not-null) value
            root = stack.pop();

            // check for valid BST: root is bigger than left child
            if(pre != null && root.val <= pre.val)
                return false;
            
            // set 'pre' to left-most value -> for validation (right is bigger than left)
            pre = root;
            // step right for in-order
            root = root.right;
        }

        return true;
    }
    
    // // helper function with given range of values.
    // // Ensures that node and its children are in valid range
    // private boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
    //     // edge-case: null
    //     if(node == null)
    //         return true;
        
    //     // case: not inside of range
    //     if((min != null && node.val <= min) || (max != null && node.val >= max))
    //         return false;
        
    //     // recursive call (for both children)
    //     // for left: decrease max-range; for right: decrease min-range
    //     return isValidBSTHelper(node.left, min, node.val) &&
    //         isValidBSTHelper(node.right, node.val, max);
    // }
}