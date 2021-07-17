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
    ListNode newList=null;
    public ListNode removeElements(ListNode head, int val) {
        solve(null,head,val);
        return newList;
    }
    
    void solve(ListNode myHead,ListNode node,int val)
    {
        if(node==null)
            return;
        if(node.val==val)
        {
            solve(myHead,node.next,val);
        }
        else
        {
            if(myHead==null)
            {
                myHead=new ListNode(node.val,null);
                newList=myHead;
                solve(myHead,node.next,val);
            }
            else
            {
                myHead.next=new ListNode(node.val,null);
                myHead=myHead.next;
                solve(myHead,node.next,val);
            }
        }
    }
}