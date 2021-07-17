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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-10000,null);
        ListNode curr=head;
        
        while(l1!=null && l2!=null)
        {
            int val1=l1.val;
            int val2=l2.val;
            
            if(val1<val2)
            {   
                if(curr!=null && curr.val == -10000)
                    curr.val=val1;
                else
                {
                    curr.next=new ListNode(val1,null);
                    curr=curr.next;
                }    
                l1=l1.next;
            }
            else
            {
                if(curr!=null &&  curr.val == -10000)
                    curr.val=val2;
                else
                {
                    curr.next=new ListNode(val2,null);
                    curr=curr.next;
                }    
                l2=l2.next;
            }
        }
        while(l1!=null)
        {
            int val1=l1.val;
            if(curr.val == -10000)
                    curr.val=val1;
            else
            {
                curr.next=new ListNode(val1,null);
                curr=curr.next;
            }    
            l1=l1.next;
        }
        while(l2!=null)
        {
            int val2=l2.val;
            if(curr.val == -10000)
                    curr.val=val2;
           else
            {
                curr.next=new ListNode(val2,null);
                curr=curr.next;
            }    
            l2=l2.next;
        }
        if(head.val==-10000)
            head=null;
        return head;
    }
}