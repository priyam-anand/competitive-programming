class Solution {
    int dp[][];
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        
        return solve(s,t,n,m);
    }
    public int solve(String s,String t,int n,int m)
    {
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int j=0;j<=m;j++)
            dp[0][j]=j;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[n][m];
    }
}