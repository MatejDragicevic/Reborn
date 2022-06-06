/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA.next == null || headB.next == null) return null;
        ListNode tempA = headA.next;
        ListNode nextA = tempA.next;
        
        ListNode tempB = headB.next;
        ListNode nextB = tempB.next;
        int sizeA = 1;
        int sizeB = 1;
        while(nextA!=null && nextB!=null) {
            if(tempA.val == tempB.val)
        }
        if(tempA.next != null)
        ListNode nextA = tempA.next;
        ListNode nextB = tempB.next;
        
        ListNode tempA = headA.next;
        int nodesA = 0;
        ListNode tempB = headB.next;
        int nodesB = 0;
        ListNode intersect = new ListNode();
        while(tempA.next != null && tempB.next != null) {
            if(tempA.next != null)
            {
                tempA = tempA.next;
                nodesA++;
                
            }
            if(tempB.next != null)
            {
                tempB = tempB.next;
                nodesB++;
            }
                tempB = tempB.next;
            if(tempA.next == null )
        }
    }
}