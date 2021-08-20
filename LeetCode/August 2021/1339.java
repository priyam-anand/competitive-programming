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
    long ans = 0, totalSum = 0;
    public int maxProduct(TreeNode root)
    {
        totalSum = dfs(root);
        dfs(root);
        return (int) (ans % (1e9+7));
    }
    
    int dfs(TreeNode root) 
    {
        if (root == null) return 0;
        int currSum = dfs(root.left) + dfs(root.right) + root.val;
        ans = Math.max(ans, (totalSum - currSum) * currSum);
        return currSum;
    }
}