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
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        solve(root,targetSum,new ArrayList<>());
        return ans;
    }
    public void solve(TreeNode root,int target, List<Integer> list)
    {   
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {   
            if(target==root.val)
            {
                list.add(root.val);
                ans.add(list);
            }    
            return;
        }     
        
        // if(root.val>target)
        //     return;
        
        List<Integer> n=new ArrayList<>();
       
        if(root.left!=null)
        {
            for(int i:list)
                n.add(i);
            n.add(root.val);
            solve(root.left,target-root.val,n);
        } 
        if(root.right!=null)
        {   
            n=new ArrayList<>();
            for(int i:list)
                n.add(i);
            n.add(root.val);
            solve(root.right,target-root.val,n);
        } 
    }
}