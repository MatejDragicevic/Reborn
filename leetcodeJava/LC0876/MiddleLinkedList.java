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
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
            count++;
        }
        temp = head;
        for(int i = 0; i<count/2;i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    // fast and concise
    public ListNode middleNodeSlowFast(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // for some reason faster than the iterative fast
    public ListNode middleNodeRecursiveSlow(ListNode head) {
        if(head==null || head.next==null) return head;
        int count = nodeCount(head.next, 2);
        return traverse(head.next, count/2-1);
    }
    private int nodeCount(ListNode node, int count)
    {
        if(node.next==null) return count;
        else return nodeCount(node.next, count+1);
    }
    private ListNode traverse(ListNode node, int count)
    {
        if(count==0) return node;
        return traverse(node.next, count-1);
    }
    // nonsense, but whatever
    public ListNode middleNodeRecursiveFast(ListNode head) {
        if(head==null || head.next==null) return head;
        int count = nodeCount(head.next, 2);
        return count/2>1 ? traverse(head.next.next, count/2-2) : head.next;
    }
    private int nodeCount(ListNode node, int count)
    {
        if(node==null) return count-1;
        if(node.next==null) return count;
        else return nodeCount(node.next.next, count+2);
    }
    private ListNode traverse(ListNode node, int count)
    {
        if(count==0) return node;
        return count>1 ? traverse(node.next.next, count-2) : node.next;
    }
}