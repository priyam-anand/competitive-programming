class Solution {
    
    int dp[][];
    
    public int numTeams(int[] rating) {
        
        int arr[]=new int[rating.length];
        int max=100000+5;
        for(int i=0;i<arr.length;i++)
            arr[i]=rating[arr.length-1-i];
        
        dp=new int[max+1][4];
        for(int i=0;i<max+1;i++)
            for(int j=0;j<4;j++)
                dp[i][j]=-1;
        int val1=solve(arr,0,rating.length,100000);
        
        dp=new int[max+1][4];
        for(int i=0;i<max+1;i++)
            for(int j=0;j<4;j++)
                dp[i][j]=-1;
        int val2=solveRev(arr,0,rating.length,0);
        
        return val1+val2;
    }
    public int solve(int a[],int l,int n,int min)
    {   
        if(dp[min][l]!=-1)
            return dp[min][l];
        if(l==3)
            return dp[min][l]=1;

        if(n==0)
            return dp[min][l]=0;
        
        if(min>a[n-1])
            return dp[min][l]=solve(a,l,n-1,min)+solve(a,l+1,n-1,a[n-1]);
        else
            return dp[min][l]=solve(a,l,n-1,min);    
    }
    public int solveRev(int a[],int l,int n,int min)
    {   
        if(dp[min][l]!=-1)
            return dp[min][l];
        if(l==3)
            return dp[min][l]=1;
        
        if(n==0)
            return dp[min][l]=0; 
        
        if(min<a[n-1])
            return dp[min][l]=solveRev(a,l,n-1,min)+solveRev(a,l+1,n-1,a[n-1]);
        else
            return dp[min][l]=solveRev(a,l,n-1,min);    
    }
}