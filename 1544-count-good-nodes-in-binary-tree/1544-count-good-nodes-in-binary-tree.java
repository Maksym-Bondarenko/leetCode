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
    public int goodNodes(TreeNode root) {
        // Idea: use DFS for Tree-traversal and keep track on the current largest element
        // alternatively: make counter a global variable and increment it by good nodes, instead of saving value from recursive calls to children into a variable

        int currentMax = Integer.MIN_VALUE;
        int goodNodesCount = 0;

        return dfsTravers(root, currentMax);
    }

    // help-function to do recursive dfs and calculate amount of good nodes
    private int dfsTravers(TreeNode root, int currentMax) {
        // exit from recursion
        if (root == null)
            return 0;
        
        // recursive calls for children
        if (root.val >= currentMax) {
            // node is good, continue with updated (increased) maximum
            int leftChild = dfsTravers(root.left, root.val);
            int rightChild = dfsTravers(root.right, root.val);

            return 1 + leftChild + rightChild;
        } else {
            // node is not good, continue with old maximum
            int leftChild = dfsTravers(root.left, currentMax);
            int rightChild = dfsTravers(root.right, currentMax);

            return leftChild + rightChild;
        }
    }
}