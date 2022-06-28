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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null && n == 1) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null)
        {
            stack.push(temp);
            temp = temp.next;
        }
        if(stack.size()<n) return null;
        if(stack.size()==n) return head.next;
        ListNode next = new ListNode();
        ListNode prev = new ListNode();
        for(int i = 1; i<=n+1; i++)
        {
            temp = stack.pop();
            if(i==n-1) next = temp;
            if(i==n) temp = temp;
            if(i==n+1) prev = temp;
        }
        temp.next = null;
        if(n==1) prev.next = null;
        else prev.next = next;
        return head;
    }
}