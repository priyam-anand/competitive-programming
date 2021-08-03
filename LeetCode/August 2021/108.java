/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return divide(nums,0,nums.length-1);
        
    }
    public TreeNode divide(int a[],int l,int r)
    {   
        // System.out.println("l = "+l+" r = "+r);
        if(r<l)
            return null;
        if(l==r)
            return new TreeNode(a[l],null,null);
        int mid=(l+r)/2;
        TreeNode curr=new TreeNode(a[mid],null,null);
        
        curr.left=divide(a,l,mid-1);
        curr.right=divide(a,mid+1,r);
        
        return curr;
    }
}