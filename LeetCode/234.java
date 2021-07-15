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
    ListNode rev=null;
    public boolean isPalindrome(ListNode head) 
    {   
        ListNode copy = null;
        ListNode copyHead=null;
        ListNode it=head;
        while(it != null)
        {   
            if(copy==null)
            {   
                copy=new ListNode(it.val,null);
                copyHead=copy;
            }
            else
            {
                copy.next=new ListNode(it.val,null);
                copy=copy.next;
            }
            it=it.next;
        }
        
        reverseList(head,null);
        
        while(copyHead!=null)
        {   
            if(copyHead.val!=rev.val)
                return false;
            copyHead=copyHead.next;
            rev=rev.next;
        }
        return true;
    }
    void reverseList(ListNode node,ListNode prev)
    {   
        if(node == null)
            return;
        if(node.next == null)
        {
            rev=node;
            rev.next=prev;
            return;
        }
        reverseList(node.next,node);
        node.next=prev;
    }
}