/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        if(head == null || head.next == null) return null;
        ListNode temp = head;
        while (temp.next != null)
        {
            if(!visited.add(temp)) return temp;
            temp = temp.next;
        }
        return null;
    }
}