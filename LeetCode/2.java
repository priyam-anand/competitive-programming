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
    
    ListNode head=null;
    ListNode current=null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        solve(l1,l2,0);
        return head;
    }
    void solve(ListNode node1,ListNode node2,int carry)
    {
        if(node1==null && node2==null)
        {
            if(carry>0)
                current.next=new ListNode(carry,null);
            return;
        }    
        int sum=carry;
        if(node1!=null)
        {
            sum+=node1.val;
            node1=node1.next;
        }
        if(node2!=null)
        {   
            sum+=node2.val;
            node2=node2.next;
        }
        if(current==null)
        {
            current=new ListNode(sum%10,null);
            head=current;
        }    
        else
        {
            current.next=new ListNode(sum%10,null);
            current=current.next;
        }
        solve(node1,node2,sum/10);
        
    }
}