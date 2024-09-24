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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Idea: DFS for Tree-traversal, save leaves in the LL and then combine 2
        // {Time: O(T1 + T2), where T1, T2 are the length of given trees}

        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();

        dfs(root1, leaves1);
        dfs(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    // help-function that does DFS-traversal and saves leafs-values to the given LL
    private void dfs (TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            // if no children => it's a leaf, add it to the LL
            if (node.left == null && node.right == null)
                leafValues.add(node.val);

            // iteratively repeat for both children (ok if they're empty)
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}