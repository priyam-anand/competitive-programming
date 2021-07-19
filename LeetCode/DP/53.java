class Solution {
    public int maxSubArray(int[] a) {
        
        int n=a.length;
        int max=Integer.MIN_VALUE,curr=0;
        for(int i=0;i<n;i++)
        {
            curr=Math.max(curr+a[i],a[i]);
            max=Math.max(max,curr);
        }
        return max;
    }
}