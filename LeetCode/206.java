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
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
        solve(head,null);
        return newHead;
    }
    void solve(ListNode node,ListNode prev)
    {   
        if(node == null)
            return;
        if(node.next == null)
        {
            node.next=prev;
            newHead=node;
            return;
        }
        solve(node.next,node);
        node.next=prev;
    }
}