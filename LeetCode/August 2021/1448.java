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
    int count;
    public int goodNodes(TreeNode root) {
        count=0;
        solve(root,root.val);
        return count;
    }
    public void solve(TreeNode curr,int max)
    {
        if(curr==null)
            return;
        if(curr.val>=max)
            count++;
        solve(curr.left,Math.max(max,curr.val));
        solve(curr.right,Math.max(max,curr.val));
    }
}