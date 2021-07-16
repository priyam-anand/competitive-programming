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
    public void reorderList(ListNode head) 
    {
        List<Integer> list=new ArrayList<>();
        ListNode ans=head;
        ListNode copy=head;
        
        while(copy!=null)
        {
            list.add(copy.val);
            copy=copy.next;
        }
        int i=1,j=list.size()-1;
        int count=1;
        while(i<=j)
        {
            if(count==0)
            {
                ans.next=new ListNode(list.get(i),null);
                i++;
            } 
            else
            {
                ans.next=new ListNode(list.get(j),null);
                j--;
            }
            count=count^1;
            ans=ans.next;
        }        
    }
}