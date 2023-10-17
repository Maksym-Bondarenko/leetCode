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
    // // global variable (in top-down approach) for tracking max-tree-depth
    // private int answer = 0;
    
    public int maxDepth(TreeNode root) {
        // // Idea 1: (top-down approach)
        // // depth of current node is 1 + max-depth-of-children
        // // use global variable to track the overal max-depth across recursion-calls
        
        // // corner-case (current depth is 0)
        // if(root == null)
        //     return 0;
        
        // // recursive-function (root depth is defined as 1, not 0)
        // recursiveDepth(root, 1);
        
        // return answer;
        
        // Idea 2: (bottom-up approach)
        // call recursive functions first, then increment result on each iteration

        // exit from recursion
        if(root == null)
            return 0;

        // recursive calls for both children
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        // returning maximum of depths from two children (+ current node itself)
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
    
    // // help-function for top-down approach
    // private void recursiveDepth(TreeNode root, int depth) {
    //     // exit from recursion
    //     if(root.left == null && root.right == null)
    //         answer = Math.max(answer, depth);   // if leaf-node
        
    //     // recursive calls
    //     if(root.left != null)
    //         recursiveDepth(root.left, depth+1);
    //     if(root.right != null)
    //         recursiveDepth(root.right, depth+1);
    // }
}