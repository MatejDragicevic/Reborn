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
    public int sumOfLeftLeaves(TreeNode root) {
        return collectLeft(root.left, true) + collectLeft(root.right, false);
        
    }
    private int collectLeft(TreeNode node, boolean left)
    {
        if(node==null) return 0;
        if(node.left==null && node.right==null) return left ? node.val : 0;
        return collectLeft(node.left, true) + collectLeft(node.right, false);
    }
}