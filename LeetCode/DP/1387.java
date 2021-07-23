class Solution {

    int dp[];    
    public int getKth(int lo, int hi, int k) {
        dp=new int[1000000];
        for(int i=0;i<dp.length;i++)
            dp[i]=-1;
        for(int i=1;i<=hi;i++)
            if(dp[i]==-1)
                solve(i);
        
        List<Pair> list=new ArrayList<>();
        
        for(int i=lo;i<=hi;i++)
            list.add(new Pair(i,dp[i]));
        
        Collections.sort(list);
    
        return list.get(k-1).x;
        
    }
    public int solve(int n)
    {   
        if(dp[n]!=-1)
            return dp[n];
        if(n==1)
            return dp[n]=0;
        if(n%2==0)
            return dp[n]=solve(n/2)+1;
        else
            return dp[n]=solve(3*n+1)+1;
    }
    
    class Pair implements Comparable<Pair>
	{
        int x,pow;
        public Pair(int x,int pow)
        {
            this.x=x;
            this.pow=pow;
        }
		public int compareTo(Pair o) {
			
            if(pow==o.pow)
                return Integer.compare(x,o.x);
        
            return Integer.compare(pow,o.pow);
		}
		
	}
}

