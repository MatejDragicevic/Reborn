/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        boolean bothAreLeft = root.val>p.val && root.val>q.val;
        boolean bothAreRight = root.val<p.val && root.val<q.val;
        
        if(bothAreLeft) return lowestCommonAncestor(root.left, p, q);
        else if(bothAreRight) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}