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
    public ListNode swapPairs(ListNode head) {
        ListNode copy=head;
        List<Integer> list=new ArrayList<>();
        while(copy!=null)
        {   
            list.add(copy.val);
            copy=copy.next;
        }
        ListNode ans=null;
        int i=0;
        while(i<list.size())
        {
            if(i+1<list.size())
            {   
                if(ans==null)
                {
                    ans=new ListNode(list.get(i+1),null);
                    head=ans;
                }
                else
                {
                    ans.next=new ListNode(list.get(i+1),null);
                    ans=ans.next;
                }
                
                    
            }
            if(ans==null)
            {
                ans=new ListNode(list.get(i),null);
                head=ans;
            }
            else
            {
                ans.next=new ListNode(list.get(i),null);
                ans=ans.next;
            }
            i+=2;
        }
        return head;
    }
}