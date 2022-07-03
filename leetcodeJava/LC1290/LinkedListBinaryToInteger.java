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
    public int getDecimalValueIterative(ListNode head) {
        int sum = 0;
        while(head!=null)
        {
            sum <<= 1;
            sum += head.val;
            head = head.next;
        }
        return sum;
    }
    
    public int getDecimalValueRecursive(ListNode head) {
        int sum = head.val;
        return getNextBit(head.next, sum);
    }
    
    private int getNextBit(ListNode node, int sum)
    {
        if(node==null) return sum;
        sum <<= 1;
        sum += node.val;
        return getNextBit(node.next, sum);
    }
}