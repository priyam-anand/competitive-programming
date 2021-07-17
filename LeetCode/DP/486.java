class Solution {
    public boolean PredictTheWinner(int[] arr) 
    {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int sum = 0;

        for(int i=0;i<n;i++)
            sum += arr[i];

        for(int i=0;i<n;i++)
            dp[i][i] = arr[i];

        for(int i=0;i+1<n;i++)
            dp[i][i+1] = Math.max(arr[i], arr[i+1]);

        for(int l=3;l<=n;l++)
            for(int i=0;i<n && i+l-1<n;i++){
                int j = i+l-1;
                dp[i][j] = Math.max(arr[i]
                                + Math.min(dp[i+2][j], dp[i+1][j-1])
                        , arr[j]
                                + Math.min(dp[i+1][j-1], dp[i][j-2]));
            }

        return 2*dp[0][n-1] >= sum;
    }   
}