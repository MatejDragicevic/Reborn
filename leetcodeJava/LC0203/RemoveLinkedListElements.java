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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val) return removeElements(head.next,val);
        ListNode prev = head;
        while(prev!=null && prev.next != null)
        {
            if(prev.next.val==val)
            {
                if(prev.next.next == null)
                {
                    prev.next = null;
                    return head;
                }
                else
                {
                    ListNode temp = prev.next;
                    while(temp!=null && temp.val == val) temp = temp.next;
                    prev.next = temp;
                }
            }
            prev = prev.next;
        }
        return head;
    }
    public ListNode removeElementsRecursion(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements(head.next,val);
        return head.val!=val ? head : head.next;
    }
}