/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        root.next = null;
        if(root.left==null) return root;
        root.left.next = root.right;
        root.right.next = null;
        if(root.right != null) setNext(root.right);
        if(root.left != null) setNext(root.left);
        return root;
    }
    private void setNext(Node node)
    {
        if(node == null || node.left==null) return;
        if(node.next!= null)
            node.right.next = node.next.left;
        else node.right.next = null;
        node.left.next = node.right;
        if(node.right!=null) setNext(node.right);
        if(node.left!=null) setNext(node.left);
    }
}