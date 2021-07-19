class Solution {
    public int getMaximumGenerated(int n) {
        int ans[]=new int[n+3];
        ans[0]=0;
        ans[1]=1;
        if(n<2)
            return ans[n];
        int ret=1;
        for(int i=2;i<=n;i++)
        {
            if(i%2==0)
                ans[i]=ans[i/2];
            else
                ans[i]=(ans[i/2]+ans[(i+1)/2]);
            
            ret=Math.max(ret,ans[i]);
        }
        return ret;
    }
}