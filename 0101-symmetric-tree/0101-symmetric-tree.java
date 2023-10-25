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
    public boolean isSymmetric(TreeNode root) {
        // // Idea 1: (recursive check)
        // // call recursive function to check the symmetricity for 2 children-nodes
        
        // // according to constraints, root cannot be null
        // return areChildrenSymmetric(root.left, root.right);
        
        // Idea 2: (iterative check with Stack)
        // Use stack, fill it in right order with left-left & right-right and left-right & right-left nodes
        // check for asymetrie (values and null-node) when poping ele,ents (should have same values)
        // Visual interpretation: checks go from the 'outsides' if tree to the 'insides'

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;

        // INITIAL STEPS
        if(root.left != null) {
            // check for asymetrie (left node, right null)
            if(root.right == null)
                return false;

            // add both non-null nodes to stack    
            stack.push(root.left);
            stack.push(root.right);
        } else if(root.right != null)
            return false;   // check for asymetrie (left null, right node)
            
        // LOOP-STEPS WITH STACK
        while(!stack.empty()) {
            // check for asymetrie (odd amount of rest nodes)
            if(stack.size() % 2 != 0)
                return false;

            // ! correct order
            right = stack.pop();
            left = stack.pop();

            // check for asymetrie (unequal values)
            if(right.val != left.val)
                return false;
            
            // check for left-left AND right-right
            if(left.left != null) {
                // check for asymetrie (left-left is node, right-right is null)
                if(right.right == null)
                    return false;

                stack.push(left.left);
                stack.push(right.right);
            } else if(right.right != null)
                return false;   // check for asymetrie (left-left is null, right-right is node)
                
            // check for left-right AND right-left
            if(left.right != null) {
                // check for asymetrie (left-right is node, right-left is null)
                if(right.left == null)
                    return false;

                stack.push(left.right);
                stack.push(right.left);
            } else if(right.left != null)
                return false;   // check for asymetrie (left-right is null, right-left is node)
        }
        
        return true;
        
        // Idea 3: (traversals)
        // traverse left-part in-order (left -> root -> right)
        // traverse right-part backwards in-order (right -> root -> left)
        // assert equality of both parts ! use NULL for 'missing' nodes !
    }
    
    private boolean areChildrenSymmetric(TreeNode leftNode, TreeNode rightNode) {
        // check null-cases (if one node is null, other MUST be null)
        // e.g. null, no_null -> false; not_null, null -> false; null, null -> true; not_null, not_null -> skip
        if(leftNode == null || rightNode == null)
            return leftNode == rightNode;
        
        // check values
        if(leftNode.val != rightNode.val)
            return false;
        
        // recursive call (with symmetric parameters from given nodes)
        return areChildrenSymmetric(leftNode.left, rightNode.right) &&
               areChildrenSymmetric(leftNode.right, rightNode.left);
    }
}