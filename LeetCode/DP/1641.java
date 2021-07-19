class Solution {
    public int countVowelStrings(int n) {
        return solve(n);
    }
    public int solve(int n)
    {
        char arr[]={'a','e','i','o','u'};
        
        int dp[][]=new int[6][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i]=0;
        for(int i=0;i<=5;i++)
            dp[i][0]=1;
        
        for(int i=1;i<=5;i++)
        {
            for(int j=1;j<=n;j++)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
        return dp[5][n];
    }
}