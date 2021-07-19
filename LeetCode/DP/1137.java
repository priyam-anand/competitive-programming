class Solution {
    int dp[];
    public int tribonacci(int n) {
        dp=new int[n+5];
        for(int i=0;i<n+5;i++)
            dp[i]=-1;
        
        return solve(n);
        
    }
    public int solve(int n)
    {   
        if(dp[n]!=-1)
            return dp[n];
        if(n==0)
            return dp[n]=0;
        if(n==1)
            return dp[n]=1;
        if(n==2)
            return dp[n]=1;
        
        return dp[n]=solve(n-1)+solve(n-2)+solve(n-3);
    }
}