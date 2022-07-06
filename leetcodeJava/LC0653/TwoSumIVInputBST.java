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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        seen.add(root.val);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.left!=null)
            {
                if(seen.contains(k-node.left.val)) return true;
                seen.add(node.left.val);
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                if(seen.contains(k-node.right.val)) return true;
                seen.add(node.right.val);
                queue.add(node.right);                
            }
        }
        return false;
    }
}